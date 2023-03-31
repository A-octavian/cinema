package com.example.cinemaproiectis.services;

import com.example.cinemaproiectis.models.User;
import com.example.cinemaproiectis.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public void registerNewUser(User user){
        Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());
        userRepository.save(user);
        if( userOptional.isPresent()){
            throw new IllegalStateException("email already in use");
        }
    }
}

