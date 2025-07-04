package com.abod.khedma_link.Service.Imp;

import com.abod.khedma_link.Model.DTO.User.Login;
import com.abod.khedma_link.Model.DTO.User.UpdateUser;
import com.abod.khedma_link.Model.DTO.User.UserDto;
import com.abod.khedma_link.Model.Entity.Rating;
import com.abod.khedma_link.Model.Entity.User;
import com.abod.khedma_link.Model.Mapper.UserMapper;
import com.abod.khedma_link.Model.Rep.RatingRep;
import com.abod.khedma_link.Model.Rep.UserRep;
import com.abod.khedma_link.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {


    private final UserRep userRep;

    private final RatingRep ratingRep;

    public UserServiceImp(UserRep userRep, RatingRep ratingRep) {
        this.userRep = userRep;
        this.ratingRep = ratingRep;
    }


    @Override
    public ResponseEntity<?> creatUser(UserDto request) {
        User newUser = UserMapper.getUser(request);
        try {
            newUser = this.userRep.save(newUser);
            if (newUser == null)
                return new ResponseEntity<UserDto>(HttpStatus.INTERNAL_SERVER_ERROR);
            ratingRep.save(new Rating(0.0, newUser, 0));
            return new ResponseEntity<>("Account has been created", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> login(Login request) {
        try {
            User user = this.userRep.findByEmailAndPassword(request.getEmail(), request.getPassword());
            if (user == null)
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            return ResponseEntity.ok().body(user);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> allUsers() {
        List<User> users;
        try {
            users = this.userRep.findAll();
            if (users.isEmpty())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateUser(UpdateUser request) {
        int status = 0;
        try {
            switch (request.getFiledName()) {
                case "email":
                    status = this.userRep.updateEmail(request.getId(), request.getValue());
                    break;
                case "phone":
                    status = this.userRep.updatePhone(request.getId(), request.getValue());
                    break;
                case "link":
                    status = this.userRep.updateLink(request.getId(), request.getValue());
                    break;
                default:
                    return new ResponseEntity<>("INVALID FIELD NAME", HttpStatus.BAD_REQUEST);
            }
            if (status == 1){
                System.out.println(status);
                return ResponseEntity.badRequest().body(1);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Account has not been updated", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<?> deleteUser(Integer id) {
        try {
            int status = this.userRep.deleteUser(id);
            if (status == 0)
                return new ResponseEntity<>("no account found", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Account has been deleted", HttpStatus.OK);
    }


}
