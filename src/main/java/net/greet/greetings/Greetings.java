package net.greet.greetings;

import net.greet.db.SqlQuery;
import net.greet.lang.Language;

public interface Greetings {
    String greet(String name, Language language);

//    String greeted();
//
//    String greeted(String name);
//
//    Integer counter();
//
//    void clear();
//
//    void clear(String name);
//
//    void exit();
//
//    void help();
}
