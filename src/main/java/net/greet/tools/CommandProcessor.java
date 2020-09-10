package net.greet.tools;

import net.greet.GreetingsManager;
import net.greet.commands.Commands;

import java.util.*;

public class CommandProcessor extends GreetingsManager {

    public CommandProcessor(GreetingsMethods greetingsMethods) {
        super(greetingsMethods);
    }

    public void Processor() {
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                System.out.println(Colors.PURPLE + "Enter command:\n/>" + Colors.RESET);
                String strInput = scanner.nextLine();
                String[] console_input =  strInput.split(" ");

                if (verifyCommand(console_input[0])) {

                    if (console_input[0].equals(Commands.counter.toString()) && console_input.length == 1) System.out.println(counter());
                    if (console_input[0].equals(Commands.clear.toString())) clear(); // deletes all the names in the database.
                    if (console_input[0].equals(Commands.greeted.toString()) && console_input.length == 2) System.out.println(greeted(console_input[1])); // gets all the names of the people greeted by the system.
                    if (console_input[0].equals(Commands.help.toString()) && console_input.length == 1) help(); // displays all the commands available in the application and their description.
                    if (console_input[0].equals(Commands.exit.toString())) scanner.close();
                    if (console_input[0].equals(Commands.clear.toString())) clear(console_input[0]); // deletes a specific username in the database.
                    if (console_input[0].equals(Commands.greeted.toString()) && console_input.length == 1) System.out.println(greeted());; // retrieves all the names in the database.
                    if (console_input[0].equals(Commands.greeted.toString()) && console_input.length == 2) greeted(console_input[1]);
                    else if (console_input[0].equals(Commands.greet.toString()) && console_input.length == 3 || console_input[0].equals(Commands.greet.toString()) && console_input.length == 2) { // greet's the user in the console with their specified language or a default one.
                        greet(console_input);
                        System.out.println(getGreetingsString());
                    }

                } else System.out.println(console_input[0] + " is not valid command enter help for all the valid commands");
            }
        } catch (Exception e) {
           e.printStackTrace();
        }


    }

    public boolean verifyCommand(String commandInput) {
        for (Commands commands : Commands.values()) {
            if (commands.name().equals(commandInput)) return true;
        }
        return false;
    }
}
