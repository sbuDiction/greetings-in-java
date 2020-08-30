package net.greet;

import net.greet.commands.Commands;
import net.greet.interfaces.GreetingsConsoleInterface;
import net.greet.lang.Language;
import net.greet.person.Entity;
import net.greet.tools.GreetingsMethods;

import java.util.*;

public class CommandProcessor implements GreetingsConsoleInterface {
    List<String> command_history = new ArrayList<>();
    GreetingsMethods greetingsMethods = new GreetingsMethods();


    @Override
    public int greeted() {
        System.out.println("----------------------Greeted names menu");
        for (String names : greetingsMethods.getGreeted_names()) {
            System.out.println(names);
        }
        return greetingsMethods.getGreeted_names().size();
    }

    @Override
    public String greeted(String name) {
        System.out.println("hello");
        return null;
    }

    @Override
    public int counter() {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public void clear(String name) {

    }

    @Override
    public void exit() {

    }

    @Override
    public void help() {

    }


    public void Processor() {
        Scanner scanner = new Scanner(System.in);
        Entity entity = new Entity();
        System.out.println("---------------Enter command----------------------");
        while (scanner.hasNext()) {
            String command = scanner.next();
            String[] input = command.split(",");
            if (input.length == 1 && input[0].equals(Commands.greeted.toString())) {
                System.out.println(greeted());
            } else if (input.length == 2 && input[0].equals(Commands.greeted.toString())) {
                entity.setName(input[1]);
                greeted(entity.getName());
            } else if (input[0].equals(Commands.counter.toString())) {
                System.out.println("counter");
            } else if (input[0].equals(Commands.greet.toString()) && input.length == 3) {
                entity.setLanguage(input[2]);
                greet(input[1], Language.valueOf(entity.getLanguage()));
            }
        }
    }

    @Override
    public String greet(String name, Language language) {
        String username = name.substring(0, 1).toUpperCase() + name.substring(1);
        greetingsMethods.checkName(username);
        try {
            if (language.toString().equals(language.toString())) {
                System.out.println(language.getPhrase() + username);

                return language.getPhrase() + username;
            } else {
                return Language.JAPANESE.getPhrase() + username;
            }

        } catch (IllegalArgumentException argumentException) {
            argumentException.getStackTrace();
            return "No";
        }
    }
}
