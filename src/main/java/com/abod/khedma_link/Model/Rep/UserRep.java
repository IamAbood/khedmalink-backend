package com.abod.khedma_link.Model.Rep;

import com.abod.khedma_link.Model.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRep extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.email = :email AND u.password = :password")
    User findByEmailAndPassword(@Param("email") String email, @Param("password") String password);


    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.phone = :value WHERE u.id = :id")
    int updatePhone(@Param("id") Integer id, @Param("value") String value);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.email = :value WHERE u.id = :id")
    int updateEmail(@Param("id") Integer id, @Param("value") String value);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.link = :value WHERE u.id = :id")
    int updateLink(@Param("id") Integer id, @Param("value") String value);

    @Transactional
    @Modifying
    @Query("delete User u  WHERE u.id = :id")
    int deleteUser(@Param("id") Integer id);

}
