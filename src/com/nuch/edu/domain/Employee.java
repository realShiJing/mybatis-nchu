package com.nuch.edu.domain;

/**
 * Created by yangshijing on 2017/12/4 0004.
 */
public class Employee {
    private Integer id;
    private String lastName;
    private String email;
    private String gender;
    private Department dept;

    public Employee() {
    }

    public Employee(String email, String gender, Integer id, String lastName) {
        this.email = email;
        this.gender = gender;
        this.id = id;
        this.lastName = lastName;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
