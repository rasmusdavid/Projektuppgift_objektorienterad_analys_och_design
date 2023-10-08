package org.example.menu;

import org.example.ComputerChoice;
import org.example.ComputerKlockis;
import org.example.ComputerNamnis;
import org.example.ComputerSlumpis;
import org.example.menuSystem.Menu;
import org.example.menuSystem.MenuOption;
import org.example.menuSystem.MenuSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.Main.historyList;
import static org.example.menu.MainMenu.player;

public class FirstToThree extends Menu {

    private static final Scanner scanner = new Scanner(System.in);
    int playerScore = 0;
    int computerScore = 0;

    public FirstToThree() {
        super("Choose your opponent");
        menuOptions = List.of(
                new MenuOption(1, "Slumpis", () -> firstToThreeSlumpis()),
                new MenuOption(2, "Klockis", () -> firstToThreeKlockis()),
                new MenuOption(3, "Namnis", () -> firstToThreeNamnis()),
                new MenuOption(4, "Main menu", () -> MenuSystem.setState(new MainMenu()))
        );
    }

    private void firstToThreeNamnis() {
        System.out.println("First to three: Player vs Namnis");
        ComputerChoice namnis = new ComputerNamnis();
        startAGame(namnis);
    }

    private void firstToThreeKlockis() {
        System.out.println("First to three: Player vs Klockis");
        ComputerChoice klockis = new ComputerKlockis();
        startAGame(klockis);
    }

    private void firstToThreeSlumpis() {
        System.out.println("First to three: Player vs Slumpis");
        ComputerChoice slumpis = new ComputerSlumpis();
        startAGame(slumpis);
    }

    private void startAGame(ComputerChoice object) {
        List<String> moves = new ArrayList<>();
        int round = 0;
        while(playerScore < 3 && computerScore < 3){
            System.out.println("Player: " + playerScore + ", Computer: " + computerScore);
            System.out.println("Choose your weapon");
            System.out.println("1. Rock, 2. Paper, 3. Scissor");
            int play = scanner.nextInt(); scanner.nextLine();
            double comp = object.makeAChoice();
            round++;
            System.out.println(comp);
            if(play == comp){
                System.out.println("draw");
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
            moves.add(saveHistory(player.getName(), object.toString(), play, comp, round, playerScore, computerScore));
        }
        System.out.println(player.getName() + ": " + playerScore + ", " + object.toString() +  ": " + computerScore  + "\n");
        historyList.add(moves);
        for (List result : historyList) {
            for (Object move : result) {
                System.out.println(move);
            }
            System.out.println("-----------------------------------------------------------------------------");
        }

        playerScore = 0;
        computerScore = 0;
    }

    private String saveHistory(String playerName, String computerName, int playerMove, double computerMove, int round, int playerScore, int computerScore) {

        String playerMoveString = "";
        if(playerMove == 1){
            playerMoveString = "rock";
        } else if(playerMove == 2){
            playerMoveString = "paper";
        }else if (playerMove == 3){
            playerMoveString = "scissor";
        }

        String computerMoveString = "";
        if(computerMove == 1){
            computerMoveString = "rock";
        } else if(computerMove == 2){
            computerMoveString = "paper";
        }else if (computerMove == 3){
            computerMoveString = "scissor";
        }

        return ("Round "+ round + ": " + playerName
                + " picked " + playerMoveString + " and "
                + computerName + " picked " + computerMoveString
                + ". " + playerName + " " + playerScore
                + " - " + computerScore + " " + computerName);
    }
}
