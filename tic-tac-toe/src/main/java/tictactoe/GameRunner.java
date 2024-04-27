package tictactoe;

import jdk.jshell.spi.ExecutionControlProvider;

import java.util.Scanner;

public class GameRunner {

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        Scanner input = new Scanner(System.in);

        System.out.println(ticTacToe);

        do {
            try {

                char currentMark = ticTacToe.currentMark.value();
                System.out.println("Player " + currentMark + " turn: ");
                String location = input.nextLine();
                ticTacToe.take(location.charAt(0));
                System.out.println(ticTacToe);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (!ticTacToe.gameIsOver());
    }
}
