package com.abod.khedma_link.Controller;

import com.abod.khedma_link.Model.DTO.User.Login;
import com.abod.khedma_link.Model.DTO.User.UpdateUser;
import com.abod.khedma_link.Model.DTO.User.UserDto;
import com.abod.khedma_link.Service.RatingService;
import com.abod.khedma_link.Service.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
@CrossOrigin
public class UserController {

    private final UserService userService;
    private final RatingService ratingService;

    public UserController(UserService userService , RatingService ratingService) {
        this.userService = userService;
        this.ratingService = ratingService;
    }

    @PostMapping(path = "/create")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {
        return this.userService.creatUser(userDto);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> login(@RequestBody Login re) {
        return this.userService.login(re);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody UpdateUser re) {
        return this.userService.updateUser(re);
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<?> deleteUser(@RequestParam Integer id) {
        return userService.deleteUser(id);
    }

    @PutMapping(path = "/rating")
    public ResponseEntity<?> updateRating(@RequestParam Double rating, @RequestParam Integer id) {
        return this.ratingService.updateRating(rating, id);
    }



}
