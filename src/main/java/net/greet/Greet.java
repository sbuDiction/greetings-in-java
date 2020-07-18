package net.greet;

import net.greet.commands.GreetingsCommandLine;
import net.greet.greetings.Greetings;

import java.util.Scanner;

public abstract class Greet implements Greetings {

//    @Override
//    public String greet(String name, Language language) {
//        return language.phrase + " " + name;
//    }

    public static void main(String[] args) {
        Scanner scanInput = new Scanner(System.in);
        GreetingsCommandLine commandLine = new GreetingsCommandLine(scanInput.nextLine(), scanInput.nextLine(), scanInput.nextLine());
        commandLine.getUserCommand();
        commandLine.getUserName();
        commandLine.getLanguage();
        System.out.println(
                commandLine.getUserCommand() + " " +
                commandLine.getUserName() + " " +
                commandLine.getLanguage()
        );

//        System.out.println(command.greetings(scanInput.nextLine(), Language.valueOf(scanInput.nextLine())));
    }
}
