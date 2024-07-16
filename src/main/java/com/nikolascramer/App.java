package com.nikolascramer;

/**
 * Hello world!
 *
 */
public class App {
    public String getGreeting() {
        return "Hello, Word!";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
    }
}
