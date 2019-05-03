package org.visola.howthewebworks.serverside;

import java.util.Scanner;

public class Main {

    public static void main (String [] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("What's your name? ");
            String name = scanner.nextLine();
            System.out.println("Hello " + name + "!");
        }
    }

}
