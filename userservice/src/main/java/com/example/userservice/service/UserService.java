package com.example.userservice.service;
import com.example.userservice.dtos.request.UserRequest;
import com.example.userservice.dtos.response.UserResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public interface UserService {
    UserResponse createUser(UserRequest userRequest);
    //List<UserResponse> getAllUsers();
    UserResponse getUserById(Long id);
    UserResponse updateUser(UserRequest userRequest, Long id);
    HashMap<String , String> deleteUser(Long id);
}
