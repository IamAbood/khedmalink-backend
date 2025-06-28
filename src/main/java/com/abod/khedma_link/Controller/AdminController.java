package com.abod.khedma_link.Controller;

import com.abod.khedma_link.Model.Entity.Project;
import com.abod.khedma_link.Service.ProjectService;
import com.abod.khedma_link.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/admin")
@CrossOrigin
public class AdminController {


    private final ProjectService projectService;

    private final UserService userService;

    public AdminController(ProjectService projectService, UserService userService) {
        this.projectService = projectService;
        this.userService = userService;
    }

    @GetMapping(path = "/all/users")
    public ResponseEntity<?> getAllUsers() {
        return this.userService.allUsers();
    }

    @GetMapping(path = "/all/projects")
    public ResponseEntity<?> getAllProjects() {
        return this.projectService.getProjectAll();
    }


}
