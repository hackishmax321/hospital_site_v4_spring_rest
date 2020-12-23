package com.hello.FirstApp.modals;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
public class Test {

    @Id @GeneratedValue
    private int code;

    @NotNull
    private String brief;
    private String info;
    private Date issue_date;

//    Relations
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_patient_test", referencedColumnName = "id")
    private Patient id_patient;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_doctor_test", referencedColumnName = "id")
    private Doctor id_doctor;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_tech_test", referencedColumnName = "id")
    private Technician id_tech;

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public Date getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(Date issue_date) {
        this.issue_date = issue_date;
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

    public Technician getId_tech() {
        return id_tech;
    }

    public void setId_tech(Technician id_tech) {
        this.id_tech = id_tech;
    }



    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getCondition() {
        return brief;
    }

    public void setCondition(String condition) {
        this.brief = condition;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getDate() {
        return issue_date;
    }

    public void setDate(Date isue_date) {
        this.issue_date = isue_date;
    }



}
