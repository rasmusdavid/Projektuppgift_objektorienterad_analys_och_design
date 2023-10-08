package org.example;

import java.util.List;

import static org.example.Main.historyList;

public class GameHistory {

    public static void showHistory(){

        for (List result : historyList) {
            for (Object round : result) {
                System.out.println(round);
            }
            System.out.println("-----------------------------------------------------------------------------");
        }

    }

}
