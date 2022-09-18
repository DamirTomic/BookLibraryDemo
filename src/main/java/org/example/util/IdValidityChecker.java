package org.example.util;

public class IdValidityChecker
{
    final int[] pattern = {7, 3, 1};

    public boolean checkDoBValidity(String dateOfBirth, String checkDigit)
    {
        if (dateOfBirth == null || !dateOfBirth.matches("[0-9]+") || checkDigit == null || !checkDigit.matches("[0-9]+"))
        {
            return false;
        }
        return Integer.parseInt(checkDigit) == calculateDobCheckDigit(dateOfBirth);
    }

    private int calculateDobCheckDigit(String dateOfBirth)
    {
        int counter = 0;
        int checkSum = 0;
        for (char c : dateOfBirth.toCharArray())
        {
            int digit = Character.getNumericValue(c);
            checkSum += digit * pattern[counter % 3];
            ++counter;
        }
        return (checkSum % 10);
    }
}
