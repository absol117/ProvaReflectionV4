package com.luca.main;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

class DeepCopyUtil {
    // Mappa per tenere traccia degli oggetti già copiati per evitare cicli infiniti
    private Map<Object, Object> copiedObjects = new HashMap<>();

    public <T> T deepCopy(T object) throws Exception {
        return deepCopy(object, object.getClass());
    }

    private <T> T deepCopy(T object, Class<?> clazz) throws Exception {
        if (object == null) {
            return null;
        }

        if (copiedObjects.containsKey(object)) {
            // Se l'oggetto è già stato copiato, restituisci la copia esistente
            return (T) copiedObjects.get(object);
        }

        // Crea una nuova istanza dell'oggetto
        T copy = (T) clazz.getDeclaredConstructor().newInstance();

        // Aggiungi l'oggetto originale alla mappa dei copi per evitare cicli infiniti
        copiedObjects.put(object, copy);

        // Ottieni tutti i campi della classe
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true); // Abilita l'accesso ai campi privati

            // Ottieni il valore del campo dall'oggetto originale
            Object fieldValue = field.get(object);

            // Copia il valore del campo nell'oggetto copia
            if (fieldValue != null) {
                if (field.getType().isPrimitive() || field.getType().equals(String.class)) {
                    field.set(copy, fieldValue); // Copia direttamente se il campo è primitivo o una stringa
                } else {
                    // Se il campo è un oggetto complesso, esegui una copia profonda ricorsiva
                    field.set(copy, deepCopy(fieldValue, field.getType()));
                }
            }
        }

        // Se la classe ha una superclasse, esegui una copia profonda della superclasse
        if (clazz.getSuperclass() != null) {
            deepCopy(object, clazz.getSuperclass());
        }

        return copy;
    }
}

class Person {
    private String name;
    private Address address;

    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", address=" + address + "]";
    }
}

class Address {
    private String city;

    public Address(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address [city=" + city + "]";
    }
}

public class DeepCopyExample {
    public static void main(String[] args) throws Exception {
        Address address = new Address("New York");
        Person person1 = new Person("Alice", address);

        DeepCopyUtil deepCopyUtil = new DeepCopyUtil();
        Person person2 = deepCopyUtil.deepCopy(person1);

        // Modifica l'indirizzo nella copia
        person2.getAddress().setCity("Los Angeles");

        System.out.println("Original: " + person1);
        System.out.println("Copy: " + person2);
    }
}

