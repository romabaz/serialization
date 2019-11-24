package com.romabaz.serialization.standard;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static com.romabaz.serialization.GlobalDefinitions.BASE_OUTPUT_DIR;

public class PersonMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        List<String> interests = new ArrayList<>();
//        interests.add("sleeping");
//        interests.add("eating");
//        PersonV1 person1 = new PersonV1("Roman", 37, interests);
//
//        // Serialization
//        try (FileOutputStream file = new FileOutputStream(BASE_OUTPUT_DIR + "/personv1_serial.ser");
//             ObjectOutputStream out = new ObjectOutputStream(file)) {
//            out.writeObject(person1);
//        }

        // Deserialization
        try (FileInputStream file = new FileInputStream(BASE_OUTPUT_DIR + "/personv1_serial.ser");
             ObjectInputStream in = new ObjectInputStream(file)) {

            PersonV1 person2 = (PersonV1) in.readObject();

            in.close();
            file.close();

            System.out.println("Object has been deserialized ");
            System.out.println("name = " + person2.getName());
            System.out.println("surname = " + person2.getSurname());
        }

    }
}
