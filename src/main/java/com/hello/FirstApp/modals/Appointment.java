package com.hello.FirstApp.modals;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Date;

@Entity
public class Appointment {

    @Id @GeneratedValue
    private Integer code;
    private String issue;
    private String info;
    private Date due_date;
    private Time due_time;

//    Relation
    @ManyToOne(cascade = CascadeType.ALL)   //Removed LAZY fetch mode because of serialization issue
    @JoinColumn(name = "fk_patient", referencedColumnName = "id", nullable = false)
    private Patient id_patient;



    @ManyToOne(cascade = CascadeType.ALL)   //Removed LAZY fetch mode because of serialization issue
    @JoinColumn(name = "fk_doctor", referencedColumnName = "id", nullable = false)
    private Doctor id_doctor;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getDate() {
        return due_date;
    }

    public void setDate(Date due_date) {
        this.due_date = due_date;
    }

    public Time getDue_time() {
        return due_time;
    }

    public void setDue_time(Time due_time) {
        this.due_time = due_time;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public Patient getId_patient() {
        return id_patient;
    }

    public void setId_patient(Patient id_patient) {
        this.id_patient = id_patient;
    }

    public Doctor getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(Doctor id_doctor) {
        this.id_doctor = id_doctor;
    }
}
