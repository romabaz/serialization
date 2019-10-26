package com.romabaz.serialization.thrift;

import com.romabaz.serialization.thrift.definitions.Person;
import org.apache.thrift.TException;
import org.apache.thrift.TSerializer;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TCompactProtocol;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws TException, IOException {
        Person p1 = new Person("Roman", 37, Arrays.asList("sleeping", "eating"));
        TSerializer serializerBinary = new TSerializer(new TBinaryProtocol.Factory());
        TSerializer serializerCompact = new TSerializer(new TCompactProtocol.Factory());
        try (FileOutputStream fosBinary = new FileOutputStream("person_thrift_binary.bytes");
             FileOutputStream fosCompact = new FileOutputStream("person_thrift_compact.bytes")) {
            fosBinary.write(serializerBinary.serialize(p1));
            fosCompact.write(serializerCompact.serialize(p1));
        }
    }
}
