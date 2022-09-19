package org.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;

@Entity
public class Book
{
    private @Id
    @GeneratedValue Long id;
    private String name;
    private String author;

    @OneToMany
    private List<UserBookHistory> userBookHistory;

    public Book()
    {
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public List<UserBookHistory> getUserBookHistory()
    {
        return userBookHistory;
    }

    public void setUserBookHistory(List<UserBookHistory> userBookHistory)
    {
        this.userBookHistory = userBookHistory;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(name, book.name) && Objects.equals(author, book.author) && Objects.equals(userBookHistory, book.userBookHistory);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, name, author, userBookHistory);
    }

    @Override
    public String toString()
    {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", userBookHistory=" + userBookHistory +
                '}';
    }
}
