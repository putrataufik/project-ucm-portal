package com.ucmportal.services;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ucmportal.entities.Form;
import com.ucmportal.entities.User;
import com.ucmportal.repositories.FormRepo;

@Service
public class FormService {
    
    @Autowired
    private FormRepo formRepo;

    public String saveForm(String title, String type, Date date_start, Date date_end, String description, MultipartFile logoFile, String link_google_form, String status, User user){
        Form form = new Form();
        form.setTitle(title);
        form.setType(type);
        form.setDate_start(date_start);
        form.setDate_end(date_end);
        form.setDescription(description);
        try {
            form.setLogo(logoFile.getBytes());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        form.setLink_google_form(link_google_form);
        form.setStatus(status);
        form.setUser(user);
        formRepo.save(form);
        return "Form Saved In DB";
    }

    public Iterable<Form> findAll(){
        return formRepo.findAll();
    }

    public List<Form> findByTitle(String title ){
        return formRepo.findByTitleContains(title);
    }

    
}
