package org.example.util;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.example.model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.StringJoiner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MicroblinkIdParser implements UserParser
{
    private static final Logger LOGGER = Logger.getLogger(MicroblinkIdParser.class.getName());

    private final IdValidityChecker idValidityChecker = new IdValidityChecker();

    /***
     * fetches user data from the Microblink MRZ API
     * @param imageSource - URL of the image containing back side of the id
     * @return creates a User object
     */
    public User getUserDetails(String imageSource)
    {
        URL obj = null;
        try
        {
            obj = new URL("https://api.microblink.com/v1/recognizers/mrtd");
        } catch (MalformedURLException e)
        {
            LOGGER.log(Level.SEVERE, "invalid URL");
        }

        String jsonInputString = "{\n" +
                "  \"returnFullDocumentImage\": false,\n" +
                "  \"returnFaceImage\": false,\n" +
                "  \"returnSignatureImage\": false,\n" +
                "  \"allowBlurFilter\": false,\n" +
                "  \"allowUnparsedMrzResults\": false,\n" +
                "  \"allowUnverifiedMrzResults\": true,\n" +
                "  \"validateResultCharacters\": true,\n" +
                "  \"anonymizationMode\": \"FULL_RESULT\",\n" +
                "  \"anonymizeImage\": true,\n" +
                "  \"ageLimit\": 0,\n" +
                "  \"imageSource\":\"" + imageSource + "\"\n" +
                "}";

        try
        {
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.setRequestProperty("Authorization", "Bearer " + "YmRkNWJjMTQ5YWJiNGEyZGExYjQ2YmVkNDM1MmRjOTc6OGU0MTc5M2EtYmZiNS00M2ZkLWFlZWMtZDcwYjg4ZjBkN2Fl");
            con.setRequestProperty("Content-Type", "application/json");

            try (OutputStream os = con.getOutputStream())
            {
                byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }

            int responseCode = con.getResponseCode();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null)
            {
                response.append(inputLine);
            }
            in.close();

            return parseResponse(response.toString());

        } catch (IOException e)
        {
            LOGGER.log(Level.SEVERE, "IO exception: ", e);
            return null;
        }
    }

    User parseResponse(String response)
    {
        if (response == null)
        {
            LOGGER.log(Level.WARNING, "invalid response");
            return null;
        }

        JsonObject jsonObject = JsonParser.parseString(response).getAsJsonObject();
        if (jsonObject != null)
        {
            JsonObject mrzData = jsonObject.getAsJsonObject("result").getAsJsonObject("mrzData");
            String rawMrzString = mrzData.get("rawMrzString").getAsString();
            return parseRawMrz(rawMrzString);
        }

        return null;
    }

    private User parseRawMrz(String rawMrzString)
    {
        String[] parts = rawMrzString.split("\n");

        String dateOfBirth = parts[1].substring(0, 6);
        String dateOfBirthCheckDigit = parts[1].substring(6, 7);
        boolean isDoBValid = idValidityChecker.checkDoBValidity(dateOfBirth, dateOfBirthCheckDigit);
                //TODTO: && checkCompositeValidity(...);
        String lastName = parts[2].split("<<")[0];
        String[] firstNames = parts[2].split("<<")[1].split("<");

        StringJoiner firstNamejoiner = new StringJoiner(" ");
        for (String name : firstNames)
        {
            if (!name.isEmpty())
            {
                firstNamejoiner.add(name);
            }
        }

        return new User()
                .setFirstName(firstNamejoiner.toString())
                .setLastName(lastName)
                .setDateOfBirth(dateOfBirth)
                .setDoBValid(isDoBValid);
    }

}
