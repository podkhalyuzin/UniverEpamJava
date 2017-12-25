package com.company.Task10_5_12_17.portfolio;

import com.company.Task10_5_12_17.portfolio.TasksPortfolio;

public class Bees implements Runnable{

    private TasksPortfolio portfolio;
    private String name;

    public Bees(TasksPortfolio portfolio,String name) {
        this.portfolio = portfolio;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name+" is running");
        while(!portfolio.isFound()) {
            int[][] task = portfolio.getTasks().pop();
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j <portfolio.getForest()[0].length ; j++) {
                    if (task[i][j] == 1) {
                        portfolio.setFound(true);
                        System.out.println(name+" has found Vinnie");
                    }
                }
            }
        }
    }
}
