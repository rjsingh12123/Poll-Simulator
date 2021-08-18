package com.jitusingh.pollsystem.data;

import java.util.ArrayList;

public class CandidateList {
    public static ArrayList<Candidate> candidates = new ArrayList<>();

    public static ArrayList<Candidate> getCandidates() {
        return candidates;
    }

    public static void addCandidate(Candidate newCandidate) {
        candidates.add(newCandidate);
    }

    public static void incrementCandidateVote(int candidateId){
        for (Candidate currCandidate : candidates) {
            if(currCandidate.getId() == candidateId){
                currCandidate.incrementVote();
            }
        }
    }

    public static boolean checkCandidate(int newCandidate) {
        for (Candidate currCandidate : candidates) {
            if(currCandidate.getId() == newCandidate){
                return true;
            }
        }
        return false;
    }
}
