package com.ucmportal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.ucmportal.entities.User;

public interface UserRepo extends JpaRepository<User, Long>{
    List<User> findByNameContains(String name); //katanya ini fungsi untuk search nanti taro di form saja.
    User findByName(String name);
}
