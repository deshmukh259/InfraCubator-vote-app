package com.pd.voteapp.controller;

import com.pd.voteapp.entity.VoteEntity;
import com.pd.voteapp.request.VoteRequest;
import com.pd.voteapp.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/vote-api")
public class VoteController {

    @Autowired
    private VoteService voteService;

    @GetMapping(value = "/health")
    public ResponseEntity<Long> health() {
        return ResponseEntity.ok(System.currentTimeMillis());
    }

    @PostMapping(value = "/vote")
    public ResponseEntity<Long> add(@RequestBody VoteRequest voteRequest) {

        return ResponseEntity.ok(voteService.addVote(voteRequest));
    }
    @GetMapping(value = "/result")
    public ResponseEntity<Map<String, Integer>> getResult(){

        return ResponseEntity.ok(voteService.result());
    }
    @GetMapping(value = "/detail-results")
    public ResponseEntity<List<VoteEntity>> getDetailResults(){

        return ResponseEntity.ok(voteService.getDetailResults());
    }
}
