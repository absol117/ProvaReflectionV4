package com.luca.main;

import com.luca.model.Modello;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main12 {
    public static void main(String[] args) {

        try {

            Modello modello = new Modello("giorgio",22,456);

            System.out.println(modello);

            Method setName = Class.forName("com.luca.model.Persona").getDeclaredMethod("setName", String.class);

            setName.invoke(modello, "lorenzo");

            System.out.println(modello);


        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }
}
