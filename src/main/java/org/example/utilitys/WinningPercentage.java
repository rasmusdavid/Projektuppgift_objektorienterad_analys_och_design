package org.example;

import static org.example.Main.statisticList;

public class WinningPercentage {

    public static void displayTotalWinningPercentage() {

        long playerWins = statisticList.stream().filter(GameStatistics::isPlayerWin).count();
        long compWins = statisticList.stream().filter(x -> !x.isPlayerWin()).count();
        if(playerWins + compWins == 0){
            System.out.println("0% wins\n");
        } else {
        double stat = (double) playerWins / (playerWins + compWins) * 100;
        System.out.println("Your total win percentage is " + stat + "%\n");
        }

    }

    public static void displayIndividualWinningPercentage() {

        long playerWinsSlumpis = statisticList.stream()
                .filter(GameStatistics::isPlayerWin)
                .filter(x -> x.getOpponentName().equalsIgnoreCase("slumpis"))
                .count();
        long compWinsSlumpis = statisticList.stream()
                .filter(x -> !x.isPlayerWin())
                .filter(x -> x.getOpponentName().equalsIgnoreCase("slumpis"))
                .count();

        if(playerWinsSlumpis + compWinsSlumpis == 0){
            System.out.println("Opponent: Slumpis. Win percentage: 0%, Loss percentage: 0%");
        }else {
            double winPercentageSlumpis = (double) playerWinsSlumpis / (playerWinsSlumpis + compWinsSlumpis) * 100;
            double lossPercentageSlumpis = (double) compWinsSlumpis / (playerWinsSlumpis + compWinsSlumpis) * 100;
            System.out.println("Opponent: Slumpis. " + "Win percentage: " + winPercentageSlumpis + "%, " + "Loss percentage: " + lossPercentageSlumpis + "%");
        }

        long playerWinsKlockis = statisticList.stream()
                .filter(GameStatistics::isPlayerWin)
                .filter(x -> x.getOpponentName().equalsIgnoreCase("klockis"))
                .count();
        long compWinsKlockis = statisticList.stream()
                .filter(x -> !x.isPlayerWin())
                .filter(x -> x.getOpponentName().equalsIgnoreCase("klockis"))
                .count();

        if(playerWinsKlockis + compWinsKlockis == 0){
            System.out.println("Opponent: Klockis. Win percentage: 0%, Loss percentage: 0%");
        }else {
            double winPercentageKlockis = (double) playerWinsKlockis / (playerWinsKlockis + compWinsKlockis) * 100;
            double lossPercentageKlockis = (double) compWinsKlockis / (playerWinsKlockis + compWinsKlockis) * 100;
            System.out.println("Opponent: Klockis. " + "Win percentage: " + winPercentageKlockis + "%, " + "Loss percentage: " + lossPercentageKlockis + "%");
        }

        long playerWinsNamnis = statisticList.stream()
                .filter(GameStatistics::isPlayerWin)
                .filter(x -> x.getOpponentName().equalsIgnoreCase("namnis"))
                .count();
        long compWinsNamnis = statisticList.stream()
                .filter(x -> !x.isPlayerWin())
                .filter(x -> x.getOpponentName().equalsIgnoreCase("namnis"))
                .count();

        if(playerWinsNamnis + compWinsNamnis == 0){
            System.out.println("Opponent: Namnis. Win percentage: 0%, Loss percentage: 0%\n");
        }else {
            double winPercentageNamnis = (double) playerWinsNamnis / (playerWinsNamnis + compWinsNamnis) * 100;
            double lossPercentageNamnis = (double) compWinsNamnis / (playerWinsNamnis + compWinsNamnis) * 100;
            System.out.println("Opponent: Namnis. " + "Win percentage: " + winPercentageNamnis + "%, " + "Loss percentage: " + lossPercentageNamnis + "%\n");

        }
    }
}
