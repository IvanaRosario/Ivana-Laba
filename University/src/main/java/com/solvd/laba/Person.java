package com.solvd.laba;

import com.solvd.laba.interfaces.IIdentifiable;

abstract public class Person implements IIdentifiable {
    protected String name;
    protected int age;
    protected String personID;
    protected String address;
    protected String phoneNumb;

    public Person(String name, int age, String personID, String address, String phoneNumb){
        this.name = name;
        this.age = age;
        this.personID = personID;
        this.address = address;
        this.phoneNumb = phoneNumb;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonID() {
        return personID;
    }

    abstract public void academicActivity(SubjectZ subject);

}

