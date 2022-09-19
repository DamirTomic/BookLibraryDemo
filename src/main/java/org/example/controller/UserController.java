package org.example.controller;

import org.example.model.BookRepository;
import org.example.model.User;
import org.example.model.UserRepository;
import org.example.util.MicroblinkIdParser;
import org.example.util.UserParser;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class UserController
{
    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final UserParser parser = new MicroblinkIdParser();

    public UserController(UserRepository userRepository, BookRepository bookRepository)
    {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    @GetMapping("/users")
    List<User> all()
    {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    User one(@PathVariable Long id)
    {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @GetMapping("/users/late")
    List<User> lateUsers()
    {
        List<User> lateUsers = new ArrayList<>();
        bookRepository.findByLateFees().forEach(userBookHistory ->
        {
            userRepository.findById(userBookHistory.getUserId()).ifPresent(lateUsers::add);
        });

        return lateUsers;
    }

    @PostMapping("/users")
    User newUser(@RequestBody User newUser)
    {
        return userRepository.save(newUser);
    }

    @PostMapping("/users/automatic")
    User newUser(@RequestBody Map<String, String> imageSource)
    {
        String imageURL = imageSource.get("imageSource");
        MicroblinkIdParser microblinkIdParser = new MicroblinkIdParser();
        User testUser = microblinkIdParser.getUserDetails(imageURL);
        if (testUser != null)
        {
            return userRepository.save(testUser);
        } else
        {
            throw new ParsingException(imageURL);
        }
    }

    @PutMapping("users/{id}")
    User replaceUser(@RequestBody User newUser, @PathVariable Long id)
    {
        return userRepository.findById(id)
                .map(user ->
                {
                    user.setFirstName(newUser.getFirstName());
                    user.setLastName(newUser.getLastName());
                    user.setId(newUser.getId());
                    user.setDateOfBirth(newUser.getDateOfBirth());
                    user.setDoBValid(newUser.isDoBValid());
                    return userRepository.save(user);
                })
                .orElseGet(() ->
                {
                    newUser.setId(id);
                    return userRepository.save(newUser);
                });
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id)
    {
        userRepository.deleteById(id);
    }

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String userNotFoundException(UserNotFoundException ex)
    {
        return ex.getMessage();
    }

    static class UserNotFoundException extends RuntimeException
    {
        UserNotFoundException(Long id)
        {
            super("Could not find user " + id);
        }
    }

    @ResponseBody
    @ExceptionHandler(ParsingException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String parsingException(ParsingException ex)
    {
        return ex.getMessage();
    }

    static class ParsingException extends RuntimeException
    {
        ParsingException(String url)
        {
            super("Could not parse user data from URL:" + url);
        }
    }
}
