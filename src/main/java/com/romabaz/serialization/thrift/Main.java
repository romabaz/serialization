package com.romabaz.serialization.thrift;

import com.romabaz.serialization.thrift.definitions.Person;
import org.apache.thrift.TException;
import org.apache.thrift.TSerializer;
import org.apache.thrift.protocol.TBinaryProtocol;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) throws TException, IOException {
        Person p1 = new Person("Roman", 37, Arrays.asList("sleeping", "eating"));
        TSerializer serializer = new TSerializer(new TBinaryProtocol.Factory());
        byte[] personBytes = serializer.serialize(p1);
        FileOutputStream fos = new FileOutputStream("person_thrift.bytes");
        fos.write(personBytes);
        fos.close();
    }
}
