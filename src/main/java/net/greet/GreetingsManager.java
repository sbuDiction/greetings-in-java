package net.greet;

import net.greet.interfaces.GreetingsConsoleInterface;
import net.greet.lang.Language;
import net.greet.tools.GreetingsMethods;

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
                    greetingsString = getLanguageMethod(Language.valueOf(userLanguage)) + username;
                } else {
                    greetingsString = Language.JAPANESE.getPhrase() + username;
                }
            } catch (IllegalArgumentException i) {
                greetingsString = "The language entered is incorrect please enter - ['lang'] for help?";
            }
        }

    }

    @Override
    public int greeted() throws SQLException {
        System.out.println("----------------------Greeted names menu----------------------\n");
        System.out.println("-------counter = " + greetingsMethods.getGreeted_names().size() + "-------------");
        System.out.println("-------------Names-------------\n");
        for (String x : greetingsMethods.getGreeted_names().keySet()) {
            System.out.println(x + " Was greeted " + greetingsMethods.getGreeted_names().get(x) + " times" + "\n");
        }
        return 0;
    }

    @Override
    public String greeted(String name) throws SQLException {
        String message = "";
        String username = name.substring(0, 1).toUpperCase() + name.substring(1);
        for (String x : greetingsMethods.getGreeted_names().keySet()) {
            if (x.contains(username))
                return message = x + " Was greeted " + greetingsMethods.getGreeted_names().get(x) + " times.";
            else {
                return message = "Sorry it seems the userName entered does not exit.";
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
        System.out.println("----------------------------------------");
        System.out.println("     Welcome To The Greetings Menu");
        System.out.println("|-----------------|-----------------|\n" +
                "  Commands           Details\n" +
                "|-----------------|-----------------|");
        System.out.println("| greet\n" +
                "| greeted\n" +
                "| greeted [name]\n" +
                "| counter\n" +
                "| clear\n" +
                "| clear [name]\n" +
                "| exit\n" +
                "| help\n" +
                "-----------------|-----------------");
    }


    public String getGreetingsString() {
        return greetingsString;
    }

    public String getLanguageMethod(Language language) {
        return language.getPhrase();
    }

}
