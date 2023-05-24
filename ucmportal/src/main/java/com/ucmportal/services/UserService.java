package com.ucmportal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucmportal.entities.User;
import com.ucmportal.repositories.UserRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User save(User user){
        return userRepo.save(user);
    }
    public User findOne(Long nim){
        return userRepo.findById(nim).get();
    }

    public Iterable<User> findAll(){
        return userRepo.findAll();
    }

    public void removeOne(long nim){
        userRepo.deleteById(nim);
    }

    public List<User> findByName(String name){
        return userRepo.findByNameContains(name);
    }

    public User getUserByUsername(String name) {
        return userRepo.findByName(name);
    }
    
    
    
}
