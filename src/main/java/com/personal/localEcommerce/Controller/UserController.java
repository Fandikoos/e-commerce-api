package com.personal.localEcommerce.Controller;


import com.personal.localEcommerce.Model.User;
import com.personal.localEcommerce.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//Manejar solicitudes http y que s econviertan a JSON, permite comunicación con angular
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/userRegister")
    public ResponseEntity<String> registerUser(@RequestBody User user){
        User newUser = userService.saveUser(user);
        return new ResponseEntity<>("Usuario registrado correctamente", HttpStatus.CREATED);

    }
}
