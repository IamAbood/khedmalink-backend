package com.abod.khedma_link.Service;

import com.abod.khedma_link.Model.DTO.User.Login;
import com.abod.khedma_link.Model.DTO.User.UpdateUser;
import com.abod.khedma_link.Model.DTO.User.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    ResponseEntity<?> creatUser(UserDto re);

    ResponseEntity<?> updateUser(UpdateUser re);

    ResponseEntity<?> deleteUser(Integer userId);

    ResponseEntity<?> login(Login request);

    ResponseEntity<?> allUsers();




}
