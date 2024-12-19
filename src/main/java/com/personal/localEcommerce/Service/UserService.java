package com.personal.localEcommerce.Service;


import com.personal.localEcommerce.Model.User;
import com.personal.localEcommerce.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Logica de negocio, operaciones a realizar a la hora de guardar usuarios, validar cosas...
@Service
public class UserService {

    // Inyectar otras clases en esta
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }
}
