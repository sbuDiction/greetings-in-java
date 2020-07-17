package net.greet.lang;

public enum Language {
    ZULU("Sawubona"),
    ENGLISH("Hello"),
    XHOSA("Molo"),
    RUSSIAN("Zdravstvuyte"),
    FRENCH("Bonjour"),
    JAPANESE(" Konnichiwa"),
    SWAHILI("Shikamoo"),
    SOTHO("Lumela"),
    CHINESE("Nǐn hǎo");


    public final String phrase;

    Language(String phrase) {
        this.phrase = phrase;
    }
}
