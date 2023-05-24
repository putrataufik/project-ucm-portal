package com.ucmportal.controllers;

import java.io.IOException;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ucmportal.entities.Form;
import com.ucmportal.entities.User;
import com.ucmportal.services.FormService;
import com.ucmportal.services.UserService;

@RestController
@RequestMapping("/api/form")
public class FormController {
    
    @Autowired
    private FormService formService;
    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public String saveForm(@RequestParam("name") String name,
                           @RequestParam("logo_form") MultipartFile logoFile,
                           @RequestParam("title_form") String title,
                           @RequestParam("type_form") String type,
                           @RequestParam("date_start_form") Date date_start,
                           @RequestParam("date_end_form") Date date_end,
                           @RequestParam("description_form") String description,
                           @RequestParam("link_google_form") String link_google_form,
                           @RequestParam("status_form") String status) throws IOException {
        User user = userService.getUserByUsername(name);
        if (user == null) {
            throw new RuntimeException("User dengan username '" + name + "' tidak ditemukan.");
        }
    
        byte[] logo = null;
        if (logoFile != null && !logoFile.isEmpty()) {
            logo = logoFile.getBytes();
        }
    
        Form form = new Form();
        form.setTitle(title);
        form.setType(type);
        form.setDate_start(date_start);
        form.setDate_end(date_end);
        form.setDescription(description);
        form.setLogo(logo);
        form.setLink_google_form(link_google_form);
        form.setStatus(status);
        form.setUser(user);
    
        formService.saveForm(title, type, date_start, date_end, description, logoFile, link_google_form, status, user);
    
        return "Formulir berhasil disimpan.";
    }
    

        @GetMapping
        public ResponseEntity<Iterable<Form>> findAll(){
            return new ResponseEntity<>(formService.findAll(),HttpStatus.OK);
        }
        

}

