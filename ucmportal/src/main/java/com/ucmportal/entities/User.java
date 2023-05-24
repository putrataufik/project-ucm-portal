package com.ucmportal.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {
    @Id
    private Long nim;

    @Column(name="user_name", length=50)
    private String name;

    @Column(name="major_name", length=50)
    private String major;
    
    @Column(name="faculty_name", length=50)
    private String faculty;

    @Column(name="speciality_name", length=50)
    private String speciality;
    
    @Column(name="uc_email", length=50)
    private String uc_email;
    
    @Column(name="password", length=50)
    private String password;
    
    @OneToMany(mappedBy = "user")
    private List<Form> forms;
    
    public User() {
    }
    

    public User(Long nim, String name, String major, String faculty, String speciality, String uc_email,
            String password) {
        this.nim = nim;
        this.name = name;
        this.major = major;
        this.faculty = faculty;
        this.speciality = speciality;
        this.uc_email = uc_email;
        this.password = password;
    }


    public Long getNim() {
        return nim;
    }

    public void setNim(Long nim) {
        this.nim = nim;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getUc_email() {
        return uc_email;
    }

    public void setUc_email(String uc_email) {
        this.uc_email = uc_email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
