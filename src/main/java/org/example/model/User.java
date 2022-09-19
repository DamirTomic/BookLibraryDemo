package org.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User
{
    private @Id @GeneratedValue Long id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private boolean DoBValid;

    public User()
    {
    }

    public Long getId()
    {
        return id;
    }

    public User setId(Long id)
    {
        this.id = id;
        return this;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public User setFirstName(String firstName)
    {
        this.firstName = firstName;
        return this;
    }

    public String getLastName()
    {
        return lastName;
    }

    public User setLastName(String lastName)
    {
        this.lastName = lastName;
        return this;
    }

    public String getDateOfBirth()
    {
        return dateOfBirth;
    }

    public User setDateOfBirth(String dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public boolean isDoBValid()
    {
        return DoBValid;
    }

    public User setDoBValid(boolean doBValid)
    {
        DoBValid = doBValid;
        return this;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return DoBValid == user.DoBValid && Objects.equals(id, user.id) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(dateOfBirth, user.dateOfBirth);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, firstName, lastName, dateOfBirth, DoBValid);
    }

    @Override
    public String toString()
    {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", DoBValid=" + DoBValid +
                '}';
    }
}
