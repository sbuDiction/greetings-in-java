package net.greet;

import net.greet.interfaces.GreetingsConsoleInterface;
import net.greet.lang.Language;
import net.greet.tools.Colors;
import net.greet.tools.GreetingsMethods;

import java.awt.*;
import java.sql.SQLException;

public class GreetingsManager implements GreetingsConsoleInterface {
    private String greetingsString;
    GreetingsMethods greetingsMethods;

    public GreetingsManager(GreetingsMethods greetingsMethods) {
        this.greetingsMethods = greetingsMethods;
    }


    @Override
    public void greet(String[] inputArray) {
        String username = inputArray[1].substring(0, 1).toUpperCase() + inputArray[1].substring(1);
        greetingsMethods.checkName(username);
        if (inputArray.length == 2) {
            greetingsString = Language.JAPANESE.getPhrase() + username;
        } else {
            try {
                if (inputArray.length == 3) {
                    String userLanguage = inputArray[2].toUpperCase();
                    greetingsString = Colors.GREEN + getLanguageMethod(Language.valueOf(userLanguage)) + username + Colors.RESET;
                } else {
                    greetingsString = Colors.GREEN + Language.JAPANESE.getPhrase() + username + Colors.RESET;
                }
            } catch (IllegalArgumentException i) {
                greetingsString = Colors.RED + "The language entered is incorrect please enter -" + Colors.GREEN + " ['lang']" + Colors.RED + " for help?";
            }
        }

    }

    @Override
    public String greeted() throws SQLException {
        String message = "";
        System.out.println("|----------------------| Welcome to greeted names menu |----------------------|\n");
        System.out.println("|-------------------------------| Greeted Names |-----------------------------|\n");
        for (String x : greetingsMethods.getGreeted_names().keySet()) {
            if (greetingsMethods.getGreeted_names().size() == 1) {
                System.out.println(Colors.GREEN + x + " Was greeted " + Colors.BLUE + greetingsMethods.getGreeted_names().get(x) + Colors.GREEN + " times" + "\n" + Colors.RESET);
            } else {
                System.out.println(Colors.GREEN + x + " Was greeted " + Colors.BLUE + greetingsMethods.getGreeted_names().get(x) + Colors.GREEN + " times" + "\n" + Colors.RESET);
            }
        }
        return message;
    }

    @Override
    public String greeted(String name) throws SQLException {
        String message = "";
        String username = name.substring(0, 1).toUpperCase() + name.substring(1);
        for (String x : greetingsMethods.getGreeted_names().keySet()) {
            if (x.contains(username))
                return message = Colors.GREEN + x + " Was greeted " + Colors.BLUE + greetingsMethods.getGreeted_names().get(x) + Colors.GREEN + " times." + Colors.RESET;
            else {
                return message = Colors.RED + "Sorry it seems the userName entered does not exit." + Colors.RESET;
            }
        }
        return message;
    }

    @Override
    public int counter() throws SQLException {
        if (greetingsMethods.getGreeted_names().size() == 0) return 0;
        else return greetingsMethods.getGreeted_names().size();
    }

    @Override
    public void clear() {
        greetingsMethods.deletePeople();
        System.out.println("You have successfully removed all the userNames in the system");
    }

    @Override
    public void clear(String name) throws SQLException {
        String username = name.substring(0, 1).toUpperCase() + name.substring(1);
        System.out.println(username);
        greetingsMethods.deletePerson(username);
        System.out.println(username + " was successfully removed from the system");
    }


    @Override
    public void help() {
        System.out.println(Colors.YELLOW + "----------------------------------------" + Colors.RESET);
        System.out.println(Colors.PURPLE + "     Welcome To The Greetings Menu" + Colors.PURPLE);
        System.out.println(Colors.YELLOW + "|-----------------|-----------------|\n" + Colors.RESET +
                Colors.PURPLE + "  Commands           Details\n" + Colors.RESET +
                Colors.YELLOW + "|-----------------|-----------------|" + Colors.RESET);
        System.out.println("|" + Colors.PURPLE + " greet\n" + Colors.RESET +
                "| " + Colors.PURPLE + "greeted\n" + Colors.RESET +
                "|" + Colors.PURPLE + " greeted [name]\n" + Colors.RESET +
                "|" + Colors.PURPLE + " counter\n" + Colors.RESET +
                "| " + Colors.PURPLE + "clear\n" + Colors.RESET +
                "| " + Colors.PURPLE + "clear [name]\n" + Colors.RESET +
                "|" + Colors.PURPLE + " exit\n" + Colors.RESET +
                "|" + Colors.PURPLE + " help\n" + Colors.RESET +
                Colors.YELLOW + "-----------------|-----------------" + Colors.RESET);
    }


    public String getGreetingsString() {
        return greetingsString;
    }

    public String getLanguageMethod(Language language) {
        return language.getPhrase();
    }

}
