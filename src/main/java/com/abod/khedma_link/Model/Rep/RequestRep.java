package com.abod.khedma_link.Model.Rep;

import com.abod.khedma_link.Model.Entity.Request;
import com.abod.khedma_link.Model.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RequestRep extends JpaRepository<Request, Integer> {



    @Transactional
    @Modifying
    @Query("UPDATE Request u SET u.status = :value WHERE u.id = :re_id and u.project.id =:pr_id ")
    int updateRequestStatus(@Param("re_id") Integer re_id, @Param("pr_id") Integer pr_id , @Param("value") String value);

    @Transactional
    @Modifying
    @Query("DELETE FROM Request r WHERE r.project.id = :re_id AND r.status = 'pending'")
    int deleteRequest(@Param("re_id") Integer re_id);


    @Query("SELECT r.user FROM Request r WHERE r.project.id = :pr_id")
    List<User> findAllUsersByProjectId(@Param("pr_id") Integer pr_id);




}
