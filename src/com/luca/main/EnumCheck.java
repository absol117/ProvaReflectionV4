package com.luca.main;

import java.lang.reflect.Field;

public class EnumCheck {

    public enum GiornoDellaSettimana {
        LUNEDI,
        MARTEDI,
        MERCOLEDI,
        GIOVEDI,
        VENERDI,
        SABATO,
        DOMENICA
    }

    public static void main(String[] args) {

        String className = "com.luca.main.EnumCheck";
        try {
            Class<?> clazz = Class.forName(className);
            Class<?> aClass = Class.forName("com.luca.main.EnumCheck$GiornoDellaSettimana");

            System.out.println(clazz.isLocalClass());
            System.out.println(clazz.isAnonymousClass());
            System.out.println(clazz.isMemberClass());

            if (clazz.isEnum()) {
                System.out.println(className + " è una classe enumerativa.");
            } else {
                System.out.println(className + " non è una classe enumerativa.");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Classe non trovata: " + className);
        }
    }
}
