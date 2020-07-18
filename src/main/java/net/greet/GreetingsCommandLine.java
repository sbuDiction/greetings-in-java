package net.greet;

import net.greet.commands.CommandLineInterpreter;
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

    public Greetings greet = (name, language) -> {
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

    public CommandLineInterpreter interpreter = () -> {
        if (getUserCommand().equals("greet")) {
            return this.greet.greet(getUserName(), Language.valueOf(getLanguage()));
        } else if (getUserCommand().equals("greeted")) {
            return greeted();
        } else if (getUserCommand().equals("counter")) {
            return counter();
        } else if (getUserCommand().equals("clear")) {
            return clear();
        } else if (getUserCommand().equals("exit")) {
            return exit();
        } else if (getUserCommand().equals("help")) {
            return help();
        }
        return "Not a valid command";
    };

    public String greeted() {
        return null;
    }

    public String counter() {
        return null;
    }

    public String clear() {
        return null;
    }

    public String exit() {
        return null;
    }

    public String help() {
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
        GreetingsCommandLine cmd = new GreetingsCommandLine("greeted", "Sbu", "ENGLISH");

//        System.out.println(cmd.greet.greet("sbu", Language.ENGLISH));
        cmd.interpreter.interpreter();


    }
}
