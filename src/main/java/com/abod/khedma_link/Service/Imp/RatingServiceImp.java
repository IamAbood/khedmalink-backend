package com.abod.khedma_link.Service.Imp;

import com.abod.khedma_link.Model.Entity.Rating;
import com.abod.khedma_link.Model.Entity.User;
import com.abod.khedma_link.Model.Rep.RatingRep;
import com.abod.khedma_link.Model.Rep.UserRep;
import com.abod.khedma_link.Service.RatingService;
import com.abod.khedma_link.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImp implements RatingService {


    private final RatingRep ratingRep;


    public RatingServiceImp(RatingRep ratingRep) {
        this.ratingRep = ratingRep;
    }


    @Override
    public ResponseEntity<?> updateRating(Double rating, Integer userId) {
        try {
            Rating ratingEntity = this.ratingRep.findRatingByUser_Id(userId);
            int newCounter = ratingEntity.getCounter() + 1;
            double newRating = (ratingEntity.getRating() * ratingEntity.getCounter() + rating) / newCounter;

            int updated = this.ratingRep.updateRating(userId, newRating, newCounter);
            if (updated != 1)
                return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);

            return ResponseEntity.ok("Successfully updated rating");
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
