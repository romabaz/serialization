package com.romabaz.serialization.standard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PersonV1 implements Serializable {
    private final static long serialVersionUID = 1271148771245575564L;

    private String name;
    private String surname;
    private int age;
    private List<String> interests;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    PersonV1(String name, int age, String surname, List<String> interests) {
        this.name = name;
        this.age = age;
        this.surname = surname;
        this.interests = new ArrayList<>(interests);
    }

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
