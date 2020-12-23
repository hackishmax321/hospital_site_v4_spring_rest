package com.hello.FirstApp.modals;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Patient {

    @Id @GeneratedValue
    private Integer ID;
    @NotNull
    private String initial_name;
    private String surname;
    private int age;
    private String info;
    private String email;
    private String contact;

//    Use with Many to Many
    private String[] issues;

    private boolean q1;
    private boolean q2;
    private boolean q3;
    private boolean q4;

    @Column(unique = true)
    private String auth_code;


    //    Relations
    @OneToMany(targetEntity = Appointment.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Appointment> appointment_list;

    @OneToMany(targetEntity = Appointment.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Test> test_list;

    public String[] getIssues() {
        return issues;
    }

    public void setIssues(String[] issues) {
        this.issues = issues;
    }

    public String getAuth_code() {
        return auth_code;
    }

    public void setAuth_code(String auth_code) {
        this.auth_code = auth_code;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getInitial_name() {
        return initial_name;
    }

    public void setInitial_name(String initial_name) {
        this.initial_name = initial_name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public boolean isQ1() {
        return q1;
    }

    public void setQ1(boolean q1) {
        this.q1 = q1;
    }

    public boolean isQ2() {
        return q2;
    }

    public void setQ2(boolean q2) {
        this.q2 = q2;
    }

    public boolean isQ3() {
        return q3;
    }

    public void setQ3(boolean q3) {
        this.q3 = q3;
    }

    public boolean isQ4() {
        return q4;
    }

    public void setQ4(boolean q4) {
        this.q4 = q4;
    }

    public List<Appointment> getAppointment_list() {
        return appointment_list;
    }

    public void setAppointment_list(List<Appointment> appointment_list) {
        this.appointment_list = appointment_list;
    }



}
