package com.manager.service;

import com.manager.entity.User;
import com.manager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getOne(Integer id) {
        return userRepository.getOne(id);
    }
    public void save(User contact){
        userRepository.save(contact);
    }

    public void delete(Integer id) {
        userRepository.deleteById(id);
    }
}
