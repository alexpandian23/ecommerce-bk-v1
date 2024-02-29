package com.example.login.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.login.model.Login;


@Repository
public interface LoginRepo extends JpaRepository<Login, Integer>{

//    
//    @Query(value = "SELECT * FROM LOGIN WHERE email == : email", nativeQuery = true)
//
//    List<Login>findByeEmail(String email);
//    
    
    
    @Query(value = "Select * from logindetail Where username = :username AND password = :password", nativeQuery = true)
    Login findBy(String username, String password);
    
}