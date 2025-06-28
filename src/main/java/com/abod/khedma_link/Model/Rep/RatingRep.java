package com.abod.khedma_link.Model.Rep;

import com.abod.khedma_link.Model.Entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface RatingRep extends JpaRepository<Rating, Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE Rating u SET u.rating =:rating , u.counter=:counter WHERE u.user.id=:id ")
    int updateRating(@Param("id") int id, @Param("rating") Double rating , @Param("counter") int counter);

    Rating findRatingByUser_Id(Integer userId);

}
