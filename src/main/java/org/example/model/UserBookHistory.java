package org.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
public class UserBookHistory
{
    @Id
    private long id;

    private long bookId;
    private long userId;

    private Date borrowDate;
    private Date returnDate;

    public UserBookHistory()
    {
    }

    public long getId()
    {
        return id;
    }

    public UserBookHistory setId(long id)
    {
        this.id = id;
        return this;
    }

    public long getBookId()
    {
        return bookId;
    }

    public UserBookHistory setBookId(long bookId)
    {
        this.bookId = bookId;
        return this;
    }

    public long getUserId()
    {
        return userId;
    }

    public UserBookHistory setUserId(long userId)
    {
        this.userId = userId;
        return this;
    }

    public Date getBorrowDate()
    {
        return borrowDate;
    }

    public UserBookHistory setBorrowDate(Date borrowDate)
    {
        this.borrowDate = borrowDate;
        return this;
    }

    public Date getReturnDate()
    {
        return returnDate;
    }

    public UserBookHistory setReturnDate(Date returnDate)
    {
        this.returnDate = returnDate;
        return this;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserBookHistory that = (UserBookHistory) o;
        return id == that.id && bookId == that.bookId && userId == that.userId && Objects.equals(borrowDate, that.borrowDate) && Objects.equals(returnDate, that.returnDate);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, bookId, userId, borrowDate, returnDate);
    }

    @Override
    public String toString()
    {
        return "UserBookHistory{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", userId=" + userId +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
