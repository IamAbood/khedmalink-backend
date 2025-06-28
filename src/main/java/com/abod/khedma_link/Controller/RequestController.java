package com.abod.khedma_link.Controller;

import com.abod.khedma_link.Model.DTO.Request.AcceptRequest;
import com.abod.khedma_link.Model.DTO.Request.SendRequest;
import com.abod.khedma_link.Service.RequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/request")
@CrossOrigin
public class RequestController {

    private final RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }


    @PostMapping(path = "/send")
    public ResponseEntity<?> sendRequest(@RequestBody SendRequest request ) {
        return this.requestService.sendRequest(request);
    }

    @PutMapping(path = "/accept")
    public ResponseEntity<?> acceptRequest(@RequestBody AcceptRequest request ) {
        return this.requestService.acceptRequest(request);
    }

    @GetMapping(path = "/project/request")
    public ResponseEntity<?> getProjectRequest(@RequestParam Integer id) {
        return this.requestService.gatAllProjectRequests(id);
    }



}
