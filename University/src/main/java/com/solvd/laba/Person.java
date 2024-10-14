package com.solvd.laba;

import com.solvd.laba.interfaces.Identifiable;

abstract public class Person implements Identifiable {
    protected String name;
    protected int age;
    protected int personID;
    protected String address;
    protected String phoneNumb;

    public Person(String name, int age, String address, String phoneNumb){
        this.name = name;
        this.age = age;
//        this.personID = personID;
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

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumb() {
        return phoneNumb;
    }

    abstract public void academicActivity(SubjectZ subject);

}

