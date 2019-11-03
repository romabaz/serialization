package com.romabaz.serialization.protobuf.usage;

import com.romabaz.serialization.protobuf.definitions.PersonOuterClass;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ProtobufMain {
    public static void main(String[] args) throws IOException {
        PersonOuterClass.Person.Builder personBuilder = PersonOuterClass.Person.newBuilder();
        PersonOuterClass.Person person = personBuilder.setName("Roman")
                .setAge(37)
                .addAllInterests(Arrays.asList("sleeping", "eating"))
                .build();
        try (FileOutputStream fosBinary = new FileOutputStream("person_proto3.bytes")) {
            person.writeTo(fosBinary);
        }
    }
}
