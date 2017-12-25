package com.company.Task10_5_12_17.competition;

public class Competition{

    private  int[] members;
    private int[] nextStandings;
    private int counter;

    public int[] getPowers() {
        return members;
    }

    public Competition(int[] members) {
        this.members = members;
        nextStandings = new int[members.length/2];
        counter=0;
    }

    public int[] getMembers() {
        return members;
    }

    public void setMembers(int[] members) {
        this.members = members;
    }

    public int[] getNextStandings() {
        return nextStandings;
    }

    public void setNextStandings(int[] nextStandings) {
        this.nextStandings = nextStandings;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    /**
     * выбирает ненулевые элементы из массива участников
     * @return
     */
    public int[] getPair(){
        for(int i=0;i<members.length;i++) {
            if (members[i]!= 0){
                int[] result = {members[i],members[i+1]};
                members[i]=0;members[i+1]=0;
                return result;
            }
        }
        return null;
    }

    public int chooseNextMember(){
        int[] pair = getPair();
        return pair[0]>=pair[1] ? pair[0] : pair[1];
    }

    public void redifine(){
        members = nextStandings;
        nextStandings = new int[counter/2];
    }
}
