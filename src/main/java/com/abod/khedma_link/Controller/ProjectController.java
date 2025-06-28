package com.abod.khedma_link.Controller;

import com.abod.khedma_link.Model.DTO.Project.CreateProject;
import com.abod.khedma_link.Service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/project")
@CrossOrigin
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping(path = "/create")
    public ResponseEntity<?> createProject(@RequestBody CreateProject request) {
        return projectService.createProject(request);
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<?> delete(@RequestParam Integer id) {
        return this.projectService.deleteProject(id);
    }

    @GetMapping(path = "/user/projects")
    private ResponseEntity<?> getUserProjects(@RequestParam Integer id) {
        return this.projectService.getProjectById(id);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<?> update(@RequestParam Integer id , @RequestParam String status){
        return this.projectService.updateProject(status, id);
    }





}
