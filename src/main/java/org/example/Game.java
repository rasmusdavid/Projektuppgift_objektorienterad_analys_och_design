package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.Main.statisticList;
import static org.example.Main.historyList;
import static org.example.StringConverter.convertResultToString;
import static org.example.menu.MainMenu.player;

public class FirstToThreeGame {

    private static final Scanner scanner = new Scanner(System.in);

    public static void startAFirstToThreeGame(ComputerChoice object) {
        List<String> moves = new ArrayList<>();
        int playerScore = 0;
        int computerScore = 0;
        int round = 0;
        while(playerScore < 3 && computerScore < 3){
            System.out.println("Player: " + playerScore + ", Computer: " + computerScore);
            System.out.println("Choose your weapon");
            System.out.println("1. Rock, 2. Paper, 3. Scissor");
            int play = scanner.nextInt(); scanner.nextLine();
            double comp = object.makeAChoice();
            round++;
            if(play == comp){
                System.out.println("It's a draw");
            }
            if(play == 1){
                if(comp == 2){
                    System.out.println("Computer picked paper. You lose");
                    computerScore++;
                } else if( comp == 3){
                    System.out.println("Computer picked scissor. You win!");
                    playerScore++;
                }
            }
            if(play == 2){
                if(comp == 1){
                    System.out.println("Computer picked rock. You win!");
                    playerScore++;
                } else if (comp == 3){
                    System.out.println("Computer picked scissor. You lose");
                    computerScore++;
                }
            }
            if(play == 3){
                if(comp == 1){
                    System.out.println("Computer picked rock. You lose");
                    computerScore++;
                } else if (comp == 2){
                    System.out.println("Computer picked paper. You win!");
                    playerScore++;
                }
            }
            moves.add(convertResultToString(player.getName(), object.toString(), play, comp, round, playerScore, computerScore));
        }
        System.out.println(player.getName() + ": " + playerScore + ", " + object.toString() +  ": " + computerScore  + "\n");
        historyList.add(moves);
        if(playerScore > computerScore){
            statisticList.add(new GameStatistics(player.getName(), object.toString(), true));
        } else statisticList.add(new GameStatistics(player.getName(), object.toString(), false));

    }
}
