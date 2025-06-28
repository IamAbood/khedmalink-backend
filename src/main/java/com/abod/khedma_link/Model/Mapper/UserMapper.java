package com.abod.khedma_link.Model.Mapper;

import com.abod.khedma_link.Model.DTO.User.UserDto;
import com.abod.khedma_link.Model.Entity.User;

import java.time.LocalDate;

public class UserMapper {

    public static User getUser(UserDto re) {
        User user = new User();
        user.setEmail(re.getEmail());
        user.setFirstName(re.getFirstName());
        user.setLastName(re.getLastName());
        user.setPassword(re.getPassword());
        user.setRole(re.getRole());
        user.setLink(re.getLink());
        user.setPhone(re.getPhone());
        user.setCreationDate(LocalDate.now());
        return user;
    }


}
