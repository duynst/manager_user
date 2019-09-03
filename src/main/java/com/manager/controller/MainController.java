package com.manager.controller;

import com.manager.entity.User;
import com.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    UserService userService;

    @GetMapping(path = "/users")
    List<User> getAll(){
        return userService.getAll();
    }

    @PostMapping("/users")
    public boolean add(@Valid @RequestBody User user) throws URISyntaxException{
        try {
            User newUser = new User(user.getName(), user.getPhone(),user.getPermission());
            userService.save(newUser);
            return true;
        }
        catch ( Exception e) {
            return false;
        }
    }

    @PostMapping("/delete")
    public boolean delete(@Valid @RequestBody User user) throws URISyntaxException{
            try {
                userService.delete(user.getId());
                return true;
            } catch (Exception e){
                e.printStackTrace();
                return false;
            }
    }

    @PutMapping("/update")
    public boolean update(@Valid @RequestBody User user) throws URISyntaxException{
        try {
            userService.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete1(@PathVariable int id){
        try {
            userService.delete(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
