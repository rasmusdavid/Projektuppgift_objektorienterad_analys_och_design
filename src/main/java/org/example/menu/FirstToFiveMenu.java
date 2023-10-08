package org.example.menu;

import org.example.menuSystem.Menu;
import org.example.menuSystem.MenuOption;
import org.example.menuSystem.MenuSystem;

import java.util.List;
import java.util.Scanner;

public class FirstToFive extends Menu {

    private static final Scanner scanner = new Scanner(System.in);
    int playerScore = 0;
    int computerScore = 0;
    public FirstToFive() {
        super("Choose your opponent");
        menuOptions = List.of(
                new MenuOption(1, "Slumpis", () -> firstToFiveSlumpis()),
                new MenuOption(2, "Klockis", () -> firstToFiveKlockis()),
                new MenuOption(3, "Namnis", () -> firstToFiveNamnis()),
                new MenuOption(4, "Main menu", () -> MenuSystem.setState(new MainMenu()))
        );
    }

    private void firstToFiveNamnis() {
        System.out.println("First to five: Player vs Namnis");
        startAGame();
    }

    private void firstToFiveKlockis() {
        System.out.println("First to five: Player vs Klockis");
        startAGame();
    }

    private void firstToFiveSlumpis() {
        System.out.println("First to five: Player vs Slumpis");
        startAGame();
    }

    private void startAGame() {
        while(playerScore < 5 && computerScore < 5){
            System.out.println("Player: " + playerScore + ", Computer: " + computerScore);
            System.out.println("Choose your weapon");
            System.out.println("1. Rock, 2. Paper, 3. Scissor");
            int play = scanner.nextInt(); scanner.nextLine();
            double comp = Math.floor(Math.random() * 3 + 1);
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
        }
        System.out.println("Player: " + playerScore + ", Computer: " + computerScore + "\n");
        playerScore = 0;
        computerScore = 0;
    }
}
