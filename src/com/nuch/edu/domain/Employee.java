package com.nuch.edu.domain;

/**
 * Created by yangshijing on 2017/12/4 0004.
 */
public class Employee {
    private int id;
    private String lastName;
    private String email;
    private String gender;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "com.nuch.edu.domain.Employee{" +
                "email='" + email + '\'' +
                ", id=" + id +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
