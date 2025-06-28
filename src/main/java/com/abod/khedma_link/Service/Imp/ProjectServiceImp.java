package com.abod.khedma_link.Service.Imp;

import com.abod.khedma_link.Model.DTO.Project.CreateProject;
import com.abod.khedma_link.Model.Entity.Project;
import com.abod.khedma_link.Model.Mapper.ProjectMapper;
import com.abod.khedma_link.Model.Rep.ProjectRep;
import com.abod.khedma_link.Service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectServiceImp implements ProjectService {


    private final ProjectRep projectRep;

    private final ProjectMapper projectMapper;

    public ProjectServiceImp(ProjectRep projectRep , ProjectMapper projectMapper) {
        this.projectRep = projectRep;
        this.projectMapper = projectMapper;
    }


    @Override
    public ResponseEntity<?> createProject(CreateProject request) {
        Project project = this.projectMapper.getProject(request);
        try {
            project = this.projectRep.save(project);
            if (project == null)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> deleteProject(int id) {

        try {
            int status = this.projectRep.deleteProject(id);
            if (status == 0)
                return new ResponseEntity<>("project not found", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateProject(String status, Integer id) {
        try {
            int isUpdated = this.projectRep.updateProject(id, status);
            if (isUpdated == 0)
                return new ResponseEntity<>("project not found", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getProjectAll() {
        List<Project> projects = this.projectRep.findAll();
        if (projects == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getProjectById(int id) {
        List<Project> projects;
        try {
            projects = this.projectRep.findProjectByUserId(id);
            if (projects == null)
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }
}
