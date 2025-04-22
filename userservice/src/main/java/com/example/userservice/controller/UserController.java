package com.example.userservice.controller;
import com.example.userservice.dtos.request.UserRequest;
import com.example.userservice.dtos.response.UserResponse;
import com.example.userservice.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/userApi")
public class UserController {
    public static UserService userService;
    public UserController(UserService userService) {

        this.userService=userService;
    }
    @PostMapping("/createUser")
    public UserResponse createUser(@RequestBody UserRequest userRequest){
        return userService.createUser(userRequest);
    }
    @GetMapping ("/getUserById/{id}")
    public UserResponse getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }
//    @GetMapping ("/getAllUsers")
//    public List<UserResponse> getAllUsers(){
//        return userService.getAllUsers();
//  }
    @PutMapping("/updateUser/{id}")
    public UserResponse updateUser(@PathVariable Long id, @RequestBody UserRequest userRequest) {
        return userService.updateUser(userRequest, id);
    }
    @DeleteMapping("/deleteUser/{id}")
    public HashMap<String, String> deleteUserById(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
}
