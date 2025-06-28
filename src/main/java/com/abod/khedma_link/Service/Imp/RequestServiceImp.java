package com.abod.khedma_link.Service.Imp;

import com.abod.khedma_link.Model.DTO.Request.AcceptRequest;
import com.abod.khedma_link.Model.DTO.Request.SendRequest;
import com.abod.khedma_link.Model.Entity.Request;
import com.abod.khedma_link.Model.Entity.User;
import com.abod.khedma_link.Model.Mapper.RequestMapper;
import com.abod.khedma_link.Model.Rep.RequestRep;
import com.abod.khedma_link.Service.RequestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestServiceImp implements RequestService {

    private final RequestMapper requestMapper;

    private final RequestRep requestRep;

    public RequestServiceImp(RequestMapper requestMapper, RequestRep requestRep) {
        this.requestMapper = requestMapper;
        this.requestRep = requestRep;
    }


    @Override
    public ResponseEntity<?> sendRequest(SendRequest data) {
        try {
            Request request = this.requestMapper.createRequest(data);
            if (request == null)
                return new ResponseEntity<>("User or project not found", HttpStatus.BAD_REQUEST);
            request = this.requestRep.save(request);
            if (request == null)
                return new ResponseEntity<>("User or project not found", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok("Request Sent");
    }

    @Override
    public ResponseEntity<?> acceptRequest(AcceptRequest data) {
        try {
            int updateStatus = this.requestRep.updateRequestStatus(data.getRe_id(), data.getPr_id(), "accepted");

            if (updateStatus == 1) {
                int deleteStatus = this.requestRep.deleteRequest(data.getPr_id());
                if (deleteStatus > 0) {
                    return new ResponseEntity<>("Request Accepted", HttpStatus.OK);
                } else {
                    return new ResponseEntity<>("Failed to delete request", HttpStatus.BAD_REQUEST);
                }
            } else {
                return new ResponseEntity<>("Failed to update request", HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> gatAllProjectRequests(Integer projectId) {
        List<User> users = null;
        try {
            users = this.requestRep.findAllUsersByProjectId(projectId);
            if (users.size() == 0)
                return new ResponseEntity<>("User or project not found", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}
