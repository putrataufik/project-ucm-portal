package com.ucmportal.entities;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "form")
public class Form {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_form")
    private Long id;

    @Column(name = "title_form")
    private String title;

    @Column(name = "type_form")
    private String type;

    @Column(name = "date_start_form")
    private Date date_start;
    
    @Column(name = "date_end_form")
    private Date date_end;

    @Column(name = "description_form", length = 1500)
    private String description;
    
    @Lob
    @Column(name = "logo_form")
    private byte[] logo ;
    
    @Column(name = "link_google_form")
    private String link_google_form;
    
	@Column(name = "status_form")
    private String status;
    
    @ManyToOne
    @JoinColumn(name = "user_nim")
    @JsonIgnoreProperties("forms")
    private User user;

    public Form() {
    }

    public Form(Long id, String title, String type, Date date_start, Date date_end, String description, byte[] logo,
            String link_google_form, String status, User user) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.date_start = date_start;
        this.date_end = date_end;
        this.description = description;
        this.logo = logo;
        this.link_google_form = link_google_form;
        this.status = status;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate_start() {
        return date_start;
    }

    public void setDate_start(Date date_start) {
        this.date_start = date_start;
    }

    public Date getDate_end() {
        return date_end;
    }

    public void setDate_end(Date date_end) {
        this.date_end = date_end;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public String getLink_google_form() {
        return link_google_form;
    }

    public void setLink_google_form(String link_google_form) {
        this.link_google_form = link_google_form;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    
    
}

    