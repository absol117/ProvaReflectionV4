package com.luca.main;

public class Main6 {
    public static void main(String[] args) {

        /*
        Crea un programma Java che accetti il nome di una classe e restituisca il numero di costruttori presenti nella classe utilizzando la riflessione.
         */

        try {
            Class<?> aClass = Class.forName("java.util.ArrayList");

            System.out.println(getNCon(aClass));

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


    public static <T> int getNCon (Class<T> clazz) {
        return clazz.getConstructors().length;
    }
}
