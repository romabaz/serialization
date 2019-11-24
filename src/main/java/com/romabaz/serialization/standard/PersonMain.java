package com.romabaz.serialization.standard;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import static com.romabaz.serialization.GlobalDefinitions.BASE_OUTPUT_DIR;

public class PersonMain {
    public static void main(String[] args) throws IOException {
        List<String> interests = new ArrayList<>();
        interests.add("sleeping");
        interests.add("eating");
        Person person1 = new PersonV1("Roman", 37, interests);

        // Serialization
        try (FileOutputStream file = new FileOutputStream(BASE_OUTPUT_DIR + "/personv1_serial.ser");
             ObjectOutputStream out = new ObjectOutputStream(file)) {
            out.writeObject(person1);
        }
    }
}
