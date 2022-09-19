package org.example.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long>
{
    @Query(value = "SELECT * FROM User_Book_History WHERE return_date IS NULL ORDER BY borrow_date ASC LIMIT 3", nativeQuery = true)
    List<UserBookHistory> findByLateFees();
}
