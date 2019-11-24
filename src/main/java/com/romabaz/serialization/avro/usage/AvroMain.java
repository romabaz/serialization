package com.romabaz.serialization.avro.usage;

import com.romabaz.serialization.avro.generated.Person;
import org.apache.avro.Protocol;
import org.apache.avro.Schema;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.specific.SpecificDatumWriter;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static com.romabaz.serialization.GlobalDefinitions.BASE_OUTPUT_DIR;

public class AvroMain {
    public static void main(String[] args) throws IOException {
        //1. Using generated classes
        Person person_gen = new Person("Roman", 37, Arrays.asList("sleeping", "eating"));
        try (DataFileWriter<Person> dataFileWriter = new DataFileWriter<>(new SpecificDatumWriter<>(Person.class))) {
            dataFileWriter.create(person_gen.getSchema(), new File(BASE_OUTPUT_DIR + "/person_gen.avro"));
            dataFileWriter.append(person_gen);
        }

        //2. Using schema directly (no pre-generated classes)
//        Schema schema_fromproto = Protocol.parse(new File("./src/main/java/com/romabaz/serialization/avro/definitions/person.avpr")).getType("Person");
        Schema schema = new Schema.Parser().parse(new File("./src/main/java/com/romabaz/serialization/avro/definitions/person.avsc"));
        GenericRecord person_schema = new GenericData.Record(schema);
        person_schema.put("name", "Roman");
        person_schema.put("age", 37);
        person_schema.put("interests", Arrays.asList("sleeping", "eating"));
        try (DataFileWriter<GenericRecord> dataFileWriter = new DataFileWriter<>(new GenericDatumWriter<>(schema))) {
            dataFileWriter.create(schema, new File(BASE_OUTPUT_DIR + "/person_schema.avro"));
        }
    }
}
