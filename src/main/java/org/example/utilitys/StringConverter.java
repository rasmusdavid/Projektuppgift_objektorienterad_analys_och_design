package org.example;

public class StringConverter {

    static String convertResultToString(String playerName, String computerName, int playerMove, double computerMove, int round, int playerScore, int computerScore) {

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
