package net.greet;

import net.greet.lang.Language;

import java.util.Scanner;

public class Greet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(Language.ZULU.phrase + " " + input + " output");
    }
}
