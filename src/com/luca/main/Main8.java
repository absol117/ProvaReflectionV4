package com.luca.main;

import com.luca.metadati.Interessanti;
import com.luca.model.Persona;

import java.io.*;

@Interessanti(value = "ho provato a capire l'interfaccia Serializable")
public class Main8 {
    public static void main(String[] args) {

        Persona persona = new Persona("luca",24);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("prova.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(persona);

            System.out.println("messaggio inviato");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try {
            FileInputStream fileInputStream = new FileInputStream("prova.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            System.out.println("messaggio ricevuto");

            Persona persona1 = (Persona) objectInputStream.readObject();

            System.out.println(persona1.toString());

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
