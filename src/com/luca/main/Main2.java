package com.luca.main;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main2 {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<?> aClass = Class.forName("java.util.ArrayList");

        Object o = aClass.getConstructors()[1].newInstance();

        List<?> list = (ArrayList<?>) o;


        List<Integer> listInt = (List<Integer>) list;

        listInt.add(2);
        System.out.println(listInt);

    }
}
