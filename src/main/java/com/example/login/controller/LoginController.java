package com.example.login.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.login.model.Login;
import com.example.login.repo.LoginRepo;

@RestController
@RequestMapping("/form")
public class LoginController {
    
    @Autowired
    private LoginRepo loginRepo;
     @CrossOrigin(origins = "http://localhost:3001")
    @PostMapping("/signup")
    
    public ResponseEntity<?> signMapping(@RequestBody Login login){
         try {
                loginRepo.saveAndFlush(login);
                return ResponseEntity.status(HttpStatus.OK)
                                     .body("Registration Successful");
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                     .body("Error occurred during registration");
            }
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:3001")
    
    public ResponseEntity<?> loginMapping(@RequestBody Login login){
        
        System.out.println(login.getUsername());
        
        String a =login.getUsername();
        String b = login.getPassword();
                 
        Login log = loginRepo.findBy(a, b);
      
      return ResponseEntity.status(HttpStatus.OK)
              .body(log);
        
    }
}