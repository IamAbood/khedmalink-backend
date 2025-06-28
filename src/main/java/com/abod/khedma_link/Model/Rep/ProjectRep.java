package com.abod.khedma_link.Model.Rep;

import com.abod.khedma_link.Model.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProjectRep extends JpaRepository<Project, Integer> {
    @Transactional
    @Modifying
    @Query("delete Project p WHERE p.id = :id")
    int deleteProject(@Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Project p SET p.status = :value WHERE p.id = :id")
    int updateProject(@Param("id") Integer id, @Param("value") String value);


    List<Project> findProjectByUserId(Integer id);


}
