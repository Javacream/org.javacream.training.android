package org.javacream.training.android.model;

import java.util.Objects;

public class Person {
    private String lastname;
    private String firstname;
    private int height;
    private char gender;
    private long id;

    public Person(String lastname, String firstname, int height, char gender, long id) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.height = height;
        this.gender = gender;
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return height == person.height &&
                gender == person.gender &&
                id == person.id &&
                Objects.equals(lastname, person.lastname) &&
                Objects.equals(firstname, person.firstname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastname, firstname, height, gender, id);
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", height=" + height +
                ", gender=" + gender +
                ", id=" + id +
                '}';
    }
}
