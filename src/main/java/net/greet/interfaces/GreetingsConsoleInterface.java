package net.greet.interfaces;

import net.greet.lang.Language;

public interface GreetingsConsoleInterface {

    String greet(String name, Language language);

    int greeted();

    String greeted(String name);

    int counter();

    void clear();

    void clear(String name);

    void exit();

    void help();
}
