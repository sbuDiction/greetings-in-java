package net.greet.greetings;

import net.greet.lang.Language;

@FunctionalInterface
public interface Greetings {
    String greet(String name, Language language);
}
