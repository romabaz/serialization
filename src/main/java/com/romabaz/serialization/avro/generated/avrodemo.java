/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.romabaz.serialization.avro.generated;

@org.apache.avro.specific.AvroGenerated
public interface avrodemo {
  public static final org.apache.avro.Protocol PROTOCOL = org.apache.avro.Protocol.parse("{\"protocol\":\"avrodemo\",\"namespace\":\"com.romabaz.serialization.avro.generated\",\"types\":[{\"type\":\"record\",\"name\":\"Person\",\"fields\":[{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"age\",\"type\":[\"null\",\"int\"],\"default\":null},{\"name\":\"interests\",\"type\":{\"type\":\"array\",\"items\":\"string\"}}]}],\"messages\":{}}");

  @SuppressWarnings("all")
  public interface Callback extends avrodemo {
    public static final org.apache.avro.Protocol PROTOCOL = com.romabaz.serialization.avro.generated.avrodemo.PROTOCOL;
  }
}