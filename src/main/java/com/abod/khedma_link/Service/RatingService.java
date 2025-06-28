package com.abod.khedma_link.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface RatingService {

    ResponseEntity<?> updateRating(Double rating , Integer userId);


}
