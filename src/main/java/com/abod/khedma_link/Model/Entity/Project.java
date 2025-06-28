package com.abod.khedma_link.Model.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.scheduling.config.Task;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String description;

    private String pricePerHour;

    private ArrayList<String> skills;

    private String status ;

    private LocalDate creationDate;

    @ManyToOne()
    @JoinColumn(name = "user_Id")
    @JsonBackReference
    private User user ;

    @OneToMany(mappedBy = "project",cascade=CascadeType.REMOVE)
    @JsonBackReference
    private Set<Request> requests = new HashSet<>();

    public Project(String title, Integer id, String pricePerHour,
                   String description, ArrayList<String> skills,
                   LocalDate creationDate ,User user, Set<Request> requests) {
        this.title = title;
        this.id = id;
        this.pricePerHour = pricePerHour;
        this.description = description;
        this.skills = skills;
        this.status = "pending";
        this.creationDate = creationDate;
        this.user = user;
        this.requests = requests;
    }

    public Project() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(String pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Request> getRequests() {
        return requests;
    }

    public void setRequests(Set<Request> requests) {
        this.requests = requests;
    }
}
