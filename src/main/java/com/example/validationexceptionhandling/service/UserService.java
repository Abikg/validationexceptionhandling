package com.example.validationexceptionhandling.service;

import com.example.validationexceptionhandling.dto.UserDto;
import com.example.validationexceptionhandling.entity.User;
import com.example.validationexceptionhandling.execptionshandler.ApplicationExceptionHandler;
import com.example.validationexceptionhandling.execptionshandler.UserNotFoundException;
import com.example.validationexceptionhandling.repository.UserRepository;
import com.example.validationexceptionhandling.validators.ObjectValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private final ObjectValidator validator;

    public User saveuser(UserDto userDto){
//        var violations = validator.validate(userDto);
//        if (!violations.isEmpty()){
//            return String.join("/n",violations);
//        }
        User user = User.build(0,userDto.getName(),userDto.getEmail(), userDto.getMobile(), userDto.getGender(), userDto.getAge(), userDto.getNationality());

        return userRepository.save(user);

    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User getUser(int id) throws UserNotFoundException {

       User user= userRepository.findById(id).orElse(null);
       if (user!=null){
           return user;

       }else {
           throw new UserNotFoundException("User Not found with id: "+id);
       }
    }
}
