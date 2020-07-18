package net.greet.commands;

import java.sql.SQLException;

@FunctionalInterface
public interface CommandLineInterpreter  {
    String interpreter() throws SQLException;
}
