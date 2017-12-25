package com.company.Task10_5_12_17.competition;

public class Compete implements Runnable {

    Competition competition;

    public Compete(Competition competition) {
        this.competition = competition;
    }

    @Override
    public void run() {
        int nextMember = competition.chooseNextMember();
        competition.getNextStandings()[competition.getCounter()] = nextMember;
        competition.setCounter(competition.getCounter()+1);
        if(competition.getCounter() == competition.getNextStandings().length){
            competition.redifine();
            competition.setCounter(0);
        }
    }
}
