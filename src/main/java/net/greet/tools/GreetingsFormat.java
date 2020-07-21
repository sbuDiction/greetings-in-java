package net.greet.tools;

import net.greet.GreetingsCommandLine;
import net.greet.commands.Commands;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GreetingsFormat {
    private static final String REGEX = "^";
    private String cmd;
    GreetingsCommandLine commandLine;

    public boolean checkFormat(GreetingsCommandLine command, GreetingsCommandLine user, GreetingsCommandLine lang) {
        Commands[] validCommands = Commands.values();
//        this.commandLine.getUserCommand() cmd = command;
        for (Commands commandList : validCommands) {
//            if (command.equals(commandList.toString())) {
//                System.out.println(command.equals(commandList.toString()));
//
//                return true;
//            }
            System.out.println(command.getUserCommand() + " Hello");
        }
        Pattern pattern = Pattern.compile(REGEX);
//        Matcher matcher = new Matcher();
//        System.out.println();
        return false;
    }

    public GreetingsCommandLine getCommandLine() {
        System.out.println(this.commandLine.getUserCommand());
        return commandLine;
    }

    public String getName() {
        return this.commandLine.getUserName();
    }

    public String getLanguage() {
        return this.commandLine.getLanguage();
    }

    public static void main(String[] args) {
        GreetingsFormat greetingsFormat = new GreetingsFormat();
        new GreetingsCommandLine("greet", "sbu", "ZULU");


//        greetingsFormat.checkFormat("greet", "Sbu", "ZULU");
        greetingsFormat.getCommandLine();
    }
}
