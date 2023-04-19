package com.pd.voteapp.service;

import com.pd.voteapp.entity.VoteEntity;
import com.pd.voteapp.repo.VoteRepository;
import com.pd.voteapp.request.VoteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;

    public Long addVote(VoteRequest voteRequest) {

        VoteEntity voteEntity = new VoteEntity();
        voteEntity.setVote(voteRequest.getVote());
        voteEntity.setName(voteRequest.getName());
        voteRepository.save(voteEntity);
        System.out.println("vote saved id " + voteEntity.getId());
        return voteEntity.getId();
    }

    public Map<String, Integer> result() {
        List<VoteEntity> all = voteRepository.findAll();
        Map<String, Integer> c = new HashMap();
        all.forEach(e -> {
            System.out.println("vote " + e.getVote() + " name " + e.getName());
            if (e.getVote() != null) {
                Integer integer = c.get(e.getVote());
                if (integer != null && integer > 0) {
                    c.put(e.getVote(), ++integer);
                } else {
                    c.put(e.getVote(), 1);
                }
            }
        });

        return c;
    }

    public List<VoteEntity> getDetailResults() {
        return voteRepository.findAll();
    }
}
