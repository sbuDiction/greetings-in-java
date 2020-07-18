package net.greet;

import net.greet.greetings.Greetings;
import net.greet.lang.Language;

import java.util.Scanner;

public class GreetingsCommandLine {
    private String userCommand;
    private String userName;
    private String language;

    public GreetingsCommandLine(String command, String name, String language) {
        this.userCommand = command;
        this.userName = name;
        this.language = language;
    }

    public Greetings greetings = (name, language) -> {
        String username = name.substring(0, 1).toUpperCase() + name.substring(1);

        try {
            if (language.toString().equals(getLanguage())) {
                return language.getPhrase() + " " + username;
            }

        } catch (Exception e) {
            System.out.println("There was an error" + e);
        }
        return Language.JAPANESE.getPhrase() + ", " + username;
    };

    public String greeted() {
        return null;
    }


    public String getUserCommand() {
        return userCommand;
    }

    public String getUserName() {
        return userName;
    }

    public String getLanguage() {
        return language;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GreetingsCommandLine cmd = new GreetingsCommandLine("greet", "Sbu", "ENGLISH");

        System.out.println(cmd.greetings.greet("sbu", Language.ENGLISH));

    }
}
