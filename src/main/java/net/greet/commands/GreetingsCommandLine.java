package net.greet.commands;

import net.greet.greetings.Greetings;

import java.util.Arrays;

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
        Cmd commands[] = Cmd.values();
        System.out.println(Arrays.toString(commands));
        return null;
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
}
