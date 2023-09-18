package com.luca.main;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main4 {
    public static void main(String[] args) {

        /*
            Ottenere le Annotazioni di una Classe o di un Metodo:
            Utilizza la riflessione per ottenere le annotazioni associate a una classe o a un metodo.
            Questo è utile quando si lavora con l'elaborazione delle annotazioni.
         */

        try {
            Class<?> aClass = Class.forName("java.util.Objects");

            /*
            Arrays.stream(aClass.getMethods())
                    .flatMap(method -> Arrays.stream(method.getAnnotations()))
                    .flatMap(annotation -> Arrays.stream(annotation.annotationType().getAnnotations()))
                    .map(annotation -> annotation.annotationType().getSimpleName())
                    .forEach(System.out::println);

            */

            Method[] methods = aClass.getDeclaredMethods();

            for (Method metodo : methods) {
                System.out.println("Metodo: " + metodo.getName());

                // Ottieni le annotazioni del metodo
                Annotation[] annotazioni = metodo.getDeclaredAnnotations();

                if (annotazioni.length > 0) {
                    System.out.println("Annotazioni:");
                    for (Annotation annotazione : annotazioni) {
                        System.out.println(" - " + annotazione.annotationType().getSimpleName());
                    }
                }
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }




    }
}
