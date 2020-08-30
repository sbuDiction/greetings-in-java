package net.greet.person;

import net.greet.CommandProcessor;

public class Entity extends CommandProcessor {
    private String command;
    private String name;
    private String language;

    public String getCommand() {
        return command;
    }

    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language.toUpperCase();
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public void setName(String name) {
        this.name = name;
    }
}
