package com.example.validationexceptionhandling.controller;

import com.example.validationexceptionhandling.dto.UserDto;
import com.example.validationexceptionhandling.entity.User;
import com.example.validationexceptionhandling.execptionshandler.UserNotFoundException;
import com.example.validationexceptionhandling.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/signup")
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserDto userDto){
        return new ResponseEntity<>(userService.saveuser(userDto), HttpStatus.CREATED);

    }
    @GetMapping("/fetchAll")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) throws UserNotFoundException {
        return ResponseEntity.ok(userService.getUser(id));
    }
}
