package org.example.model;

import java.util.Objects;

public class User
{
    private String firstName;
    private String lastName;
    private String dateOfBirth;

    private boolean DoBValid;
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
        return DoBValid == user.DoBValid && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(dateOfBirth, user.dateOfBirth);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(firstName, lastName, dateOfBirth, DoBValid);
    }

    @Override
    public String toString()
    {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", DoBValid=" + DoBValid +
                '}';
    }
}
