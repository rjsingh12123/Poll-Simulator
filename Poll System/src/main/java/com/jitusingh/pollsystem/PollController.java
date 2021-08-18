package com.jitusingh.pollsystem;

import com.jitusingh.pollsystem.data.Candidate;
import com.jitusingh.pollsystem.data.CandidateList;
import com.jitusingh.pollsystem.data.VoterList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PollController {

    @GetMapping("index")
    public String Home() {
        return "index";
    }

    @GetMapping("addcandidate")
    public String addCandidate(Model model) {
        model.addAttribute("candidates", CandidateList.getCandidates());
        return "addcandidate";
    }

    @GetMapping("vote")
    public String makeVote(Model model) {
        model.addAttribute("candidates", CandidateList.getCandidates());

        model.addAttribute("message", "");
        return "vote";
    }

    @GetMapping("summary")
    public String result(Model model) {
        model.addAttribute("candidates", CandidateList.getCandidates());
        return "summary";
    }

    @GetMapping("result")
    public String summary(Model model) {
        Candidate winner = new Candidate(0,"None"), runner = new Candidate(0,"None");
        winner.setVotes(-1);
        runner.setVotes(-1);
        for (Candidate candidate : CandidateList.getCandidates()) {
            if (candidate.getVotes() > winner.getVotes()) {
                winner = candidate;
            }else if(candidate.getVotes() > runner.getVotes()){
                runner = candidate;
            }
        }
        model.addAttribute("winner", winner);
        model.addAttribute("runner", runner);
        return "result";
    }

    @PostMapping("countvote")
    public String countVote(Model model, @RequestParam("vote") String candidate, @RequestParam("id") String voter) {
        model.addAttribute("candidates", CandidateList.getCandidates());
        if (!VoterList.checkVoted(Integer.parseInt(voter))) {
            CandidateList.incrementCandidateVote(Integer.parseInt(candidate));
            VoterList.addVoter(Integer.parseInt(voter));
            model.addAttribute("message", "Thank You For Vote");
        } else {
            model.addAttribute("message", "You Have Already Voted");
        }
        return "vote";
    }

    @PostMapping("add")
    public String add(Model model, @RequestParam("name") String candidateName, @RequestParam("id") String candidateId) {
        model.addAttribute("candidates", CandidateList.getCandidates());
        if (!CandidateList.checkCandidate(Integer.parseInt(candidateId))) {
            CandidateList.addCandidate(new Candidate(Integer.parseInt(candidateId), candidateName));
            model.addAttribute("message", "Candidate Added");
        } else {
            model.addAttribute("message", "Candidate Already Present");
        }
        return "addcandidate";
    }
}