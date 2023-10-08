package org.example;

import static org.example.Main.statisticList;

public class NumberOfWins {

    public static void displayNumberOfWins() {

        long numberOfWins = statisticList.stream()
                .filter(GameStatistics::isPlayerWin)
                .count();
        System.out.println("Your total wins are: " + numberOfWins + "\n");

    }

}
