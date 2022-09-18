package org.example;

import org.example.util.MicroblinkIdParser;
import org.example.util.UserParser;

public class Main
{
    public static void main(String[] args)
    {
        UserParser parser = new MicroblinkIdParser();
        parser.getUserDetails("https://upload.wikimedia.org/wikipedia/commons/thumb/1/10/New_Croatian_ID_Card_%28Backside%29_%282021%29.jpg/190px-New_Croatian_ID_Card_%28Backside%29_%282021%29.jpg");
        System.out.println("Finished parsing!");
    }
}