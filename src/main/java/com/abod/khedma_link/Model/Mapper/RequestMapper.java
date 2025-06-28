package com.abod.khedma_link.Model.Mapper;

import com.abod.khedma_link.Model.DTO.Request.SendRequest;
import com.abod.khedma_link.Model.Entity.Project;
import com.abod.khedma_link.Model.Entity.Request;
import com.abod.khedma_link.Model.Entity.User;
import com.abod.khedma_link.Model.Rep.ProjectRep;
import com.abod.khedma_link.Model.Rep.UserRep;
import jakarta.websocket.SendResult;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RequestMapper {


    private final UserRep userRep;

    private final ProjectRep project;

    public RequestMapper(UserRep userRep, ProjectRep project) {
        this.userRep = userRep;
        this.project = project;
    }

    public Request createRequest(SendRequest request) {
        Optional<User> user = this.userRep.findById(request.getUserId());
        Optional<Project> project = this.project.findById(request.getProjectId());
        if (user.isPresent() && project.isPresent()) {
            Request response = new Request();
            response.setUser(user.get());
            response.setProject(project.get());
            response.setStatus(request.getStatus());
            return response;
        }
       return new Request();
    }


}
