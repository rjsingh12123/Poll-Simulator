package com.jitusingh.pollsystem.data;

import java.util.ArrayList;

public class VoterList {
    public static ArrayList<Integer> voters = new ArrayList<Integer>();

    public static void addVoter(int newVoter) {
        voters.add(newVoter);
    }

    public static boolean checkVoted(int findVoter) {
        for (int prevVoter : voters) {
            if(prevVoter == findVoter){
                return true;
            }
        }
        return false;
    }
}
