package com.solvd.laba;

import com.solvd.laba.interfaces.Identifiable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlTransient
abstract public class Person implements Identifiable {
    protected String name;
    protected int age;
    protected int personID;
    protected String address;
    protected String phoneNumb;

    public Person() {

    }

    public Person(String name, int age, String address, String phoneNumb){
        this.name = name;
        this.age = age;
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
    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumb() {
        return phoneNumb;
    }

    public void setPhoneNumb(String number) {
        this.phoneNumb = number;
    }

    abstract public void academicActivity(SubjectZ subject);

}

