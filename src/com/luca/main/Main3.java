package com.luca.main;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

@SuppressWarnings("unchecked")
public class Main3 {

    public static void main(String[] args) {


        try {

            Class<?> aClass = Class.forName("java.util.ArrayList");

            Constructor<?> constructor = aClass.getConstructors()[1];
            ArrayList<Integer> arrayList = (ArrayList<Integer>) constructor.newInstance();

            arrayList.add(1);
            arrayList.add(2);

            System.out.println("la lunghezza senza reflectione è di : " + arrayList.size());

            Method size = aClass.getMethod("size");

            Object invoke = size.invoke(arrayList);

            System.out.println("La lunghezza tramite reflection è di : " + invoke);


            Method add = aClass.getMethod("add", Object.class);

            add.invoke(arrayList,4);

            Method size1 = aClass.getMethod("size");
            Object invoke1 = size1.invoke(arrayList);


            System.out.println("La lunghezza tramite reflection è di : " + invoke1);

            arrayList.forEach(System.out::println);


        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
