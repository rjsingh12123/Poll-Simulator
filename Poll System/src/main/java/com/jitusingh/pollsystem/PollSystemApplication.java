package com.jitusingh.pollsystem;

import com.jitusingh.pollsystem.data.Candidate;
import com.jitusingh.pollsystem.data.CandidateList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PollSystemApplication {

    public static void main(String[] args) {
        CandidateList.addCandidate(new Candidate(202012071,"Jitusingh"));
        CandidateList.addCandidate(new Candidate(202012054,"Pradeep"));
        CandidateList.addCandidate(new Candidate(202012091,"Himanshu"));
        SpringApplication.run(PollSystemApplication.class, args);
    }

}
