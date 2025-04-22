package com.example.userservice.service.serviceImp;
import com.example.userservice.dtos.request.UserRequest;
import com.example.userservice.dtos.response.UserResponse;
import com.example.userservice.model.User;
import com.example.userservice.repository.UserDAO;
import com.example.userservice.service.UserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserServiceImp  implements UserService {
    public  static UserDAO userdao;
    public   UserServiceImp(UserDAO userdao) {
        UserServiceImp.userdao = userdao;
    }
    @Override
    public UserResponse createUser(UserRequest userRequest) {
        User user = UserResponse.toEntity(userRequest);
        User savedUser = userdao.save(user);
        return  UserResponse.fromEntity(savedUser);
    }

//    @Override
//    public List<UserResponse> getAllUsers() {
//        return userdao.findAll().stream().map(UserResponse::fromEntity).
//                collect(Collectors.toList());
//    }

    @Override
    public UserResponse getUserById(Long id) {
        return userdao.findById(id).map(UserResponse::fromEntity).
                orElseThrow(()->new RuntimeException("Usernot found"));
    }

    @Override
    public UserResponse updateUser(UserRequest userRequest, Long id) {
        User user =userdao.findById(id).orElseThrow(
                ()->new RuntimeException("user not found with this id:"+id));
        if(user !=null){
            User u = UserResponse.toEntity(userRequest);
            u.setId(id);
            User savedUser=userdao.save(u);
            return UserResponse.fromEntity(savedUser);
        }else{
            return  null;
        }
    }

    @Override
    public HashMap<String, String> deleteUser(Long id) {
        HashMap message = new HashMap<>() ;
        User user =userdao.findById(id).orElseThrow(null);
        if(user!=null){
            try{
                userdao.deleteById(id);
                message.put("user","user deleted successfully");
            }catch(Exception e){
                message.put("user",e.getMessage());
            }
        }else {
            message.put("message", "user not found" + id);
        }
        return message;
    }
}


