namespace java com.romabaz.serialization.thrift.generated
struct Person {
    1: required string name,
    2: optional i32 age,
    3: list<string> interests
}