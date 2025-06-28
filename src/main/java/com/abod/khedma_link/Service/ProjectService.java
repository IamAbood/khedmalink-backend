package com.abod.khedma_link.Service;

import com.abod.khedma_link.Model.DTO.Project.CreateProject;
import com.abod.khedma_link.Model.Entity.Project;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ProjectService {

    ResponseEntity<?> createProject(CreateProject request);

    ResponseEntity<?> deleteProject(int id);

    ResponseEntity<?> updateProject(String status , Integer id);

    ResponseEntity<?> getProjectAll();

    ResponseEntity<?> getProjectById(int id);


}
