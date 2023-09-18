package com.luca.main;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main10 {
    public static void main(String[] args) {

        /*
            Implementa un'applicazione Java che elenchi tutti i metodi di una classe in modo gerarchico,
            mostrando anche i metodi ereditati dalle superclassi, utilizzando la riflessione.
         */


        try {
            Class<?> aClass = Class.forName("com.luca.model.Modello");

            getAllMethods(aClass).forEach(System.out::println);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    public static List<Method> getAllMethods (Class<?> clazz) {
        List<Method> methods = new ArrayList<>();

        Method[] methods1 = clazz.getMethods();

        methods.addAll(Arrays.asList(methods1));

        Method[] methods2 = clazz.getSuperclass().getMethods();

        methods.addAll(List.of(methods2));

        return methods;

    }
}
