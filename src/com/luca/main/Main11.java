package com.luca.main;

import com.luca.model.Modello;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class Main11 {
    public static void main(String[] args) {

        try {
            Modello modello = new Modello("liva",22,22222);

            Class<?> aClass = Class.forName("com.luca.model.Modello");

            Method guadagno = aClass.getDeclaredMethod("setGuadagno", int.class);

            guadagno.invoke(modello, 351);

            System.out.println(modello.toString());

        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }


    }
}
