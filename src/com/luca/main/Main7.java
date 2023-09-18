package com.luca.main;

import java.util.Arrays;

public class Main7 {
    public static void main(String[] args) {


        /*
        Scrivi un programma che utilizzi la riflessione per ottenere tutte le interfacce implementate da una classe specifica.
         */


        try {
            Class<?> aClass = Class.forName("java.util.ArrayList");

            Arrays.stream(aClass.getInterfaces()).forEach(System.out::println);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
