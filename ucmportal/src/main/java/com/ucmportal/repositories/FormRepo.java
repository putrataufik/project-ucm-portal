package com.ucmportal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ucmportal.entities.Form;

@Repository
public interface FormRepo extends JpaRepository<Form, Long> {
    List<Form> findByTitleContains(String title);
}
