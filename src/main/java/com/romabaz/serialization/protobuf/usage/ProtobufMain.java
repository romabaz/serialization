package com.romabaz.serialization.protobuf.usage;

import com.romabaz.serialization.protobuf.generated.Person2OuterClass;
import com.romabaz.serialization.protobuf.generated.Person3OuterClass;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import static com.romabaz.serialization.GlobalDefinitions.BASE_OUTPUT_DIR;

public class ProtobufMain {
    public static void main(String[] args) throws IOException {
        Person3OuterClass.Person3 person3 = Person3OuterClass.Person3.newBuilder()
                .setName("Roman")
                .setAge(37)
                .addAllInterests(Arrays.asList("sleeping", "eating"))
                .build();
        Person2OuterClass.Person2 person2 = Person2OuterClass.Person2.newBuilder()
                .setName("Roman")
                .setAge(37)
                .addAllInterests(Arrays.asList("sleeping", "eating"))
                .build();
        try (FileOutputStream fosBinary = new FileOutputStream(BASE_OUTPUT_DIR + "/person_proto3.bytes");
             FileOutputStream fosBinary2 = new FileOutputStream(BASE_OUTPUT_DIR + "/person_proto2.bytes")) {
            person3.writeTo(fosBinary);
            person2.writeTo(fosBinary2);
        }
    }
}
