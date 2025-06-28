package com.abod.khedma_link.Model.Mapper;

import com.abod.khedma_link.Model.DTO.Project.CreateProject;
import com.abod.khedma_link.Model.Entity.Project;
import com.abod.khedma_link.Model.Entity.User;
import com.abod.khedma_link.Model.Rep.UserRep;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
@Service
public class ProjectMapper {

    private final UserRep userRep;

    public ProjectMapper(UserRep userRep) {
        this.userRep = userRep;
    }



    public  Project getProject(CreateProject request) {
        Project project = new Project();
        Optional<User> optionalUser = this.userRep.findById(request.getId());
        User user = optionalUser.get();
        user.setId(request.getId());
        project.setUser(user);
        project.setDescription(request.getDescription());
        project.setPricePerHour(request.getPricePerHour());
        project.setTitle(request.getTitle());
        project.setSkills(request.getSkills());
        project.setCreationDate(LocalDate.now());
        project.setStatus("pending");
        return project;
    }

}
