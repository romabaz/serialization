package com.romabaz.serialization.thrift.usage;

import com.romabaz.serialization.thrift.generated.Person;
import org.apache.thrift.TException;
import org.apache.thrift.TSerializer;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TJSONProtocol;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import static com.romabaz.serialization.GlobalDefinitions.BASE_OUTPUT_DIR;

public class ThriftMain {
    public static void main(String[] args) throws TException, IOException {
//        Person p1 = new Person("Roman", 37, Arrays.asList("sleeping", "eating"));
        Person p1 = new Person();
        p1.setName("Roman");
        p1.setAge(37);
        p1.setInterests(Arrays.asList("sleeping", "eating"));
        TSerializer serializerBinary = new TSerializer(new TBinaryProtocol.Factory());
        TSerializer serializerCompact = new TSerializer(new TCompactProtocol.Factory());
        TSerializer serializerJson = new TSerializer(new TJSONProtocol.Factory());
        try (FileOutputStream fosBinary = new FileOutputStream(BASE_OUTPUT_DIR + "/person_thrift_binary.bytes");
             FileOutputStream fosCompact = new FileOutputStream(BASE_OUTPUT_DIR + "/person_thrift_compact.bytes");
             FileOutputStream fosJson = new FileOutputStream(BASE_OUTPUT_DIR + "/person_thrift_json.bytes")) {
            fosBinary.write(serializerBinary.serialize(p1));
            fosCompact.write(serializerCompact.serialize(p1));
            fosJson.write(serializerJson.serialize(p1));
        }
    }
}
