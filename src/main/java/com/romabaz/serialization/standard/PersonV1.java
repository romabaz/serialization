package com.romabaz.serialization.standard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PersonV1 implements Person {
    private String name;
    private int age;
    private List<String> interests;

    PersonV1(String name, int age, List<String> interests) {
        this.name = name;
        this.age = age;
        this.interests = new ArrayList<>(interests);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }
}
