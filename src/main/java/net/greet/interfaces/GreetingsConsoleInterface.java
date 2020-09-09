package net.greet.interfaces;

import java.sql.SQLException;

public interface GreetingsConsoleInterface {

    void greet(String[] inputArray);

    int greeted() throws SQLException;

    String greeted(String name) throws SQLException;

    int counter() throws SQLException;

    void clear();

    void clear(String name) throws SQLException;

    void help();
}
