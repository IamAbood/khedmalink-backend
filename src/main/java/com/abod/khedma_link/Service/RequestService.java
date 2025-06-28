package com.abod.khedma_link.Service;

import com.abod.khedma_link.Model.DTO.Request.AcceptRequest;
import com.abod.khedma_link.Model.DTO.Request.SendRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface RequestService {

    ResponseEntity<?> sendRequest(SendRequest request);

    ResponseEntity<?> acceptRequest(AcceptRequest data);

    ResponseEntity<?> gatAllProjectRequests(Integer projectId);


}
