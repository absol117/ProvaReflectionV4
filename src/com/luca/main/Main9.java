package com.luca.main;

import com.luca.model.Modello;

public class Main9 {
    public static void main(String[] args) {

        /*
        Crea un programma che verifichi se una classe è una sottoclasse di un'altra classe utilizzando la riflessione.
         */

        try {
            Class<?> aClass = Class.forName("com.luca.model.Persona");
            if(aClass.getSuperclass() != null && aClass.getSuperclass() != Object.class) {
                System.out.println(aClass.getSuperclass().getSimpleName());
            } else {
                System.out.println("non ci sono classi padre");
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
