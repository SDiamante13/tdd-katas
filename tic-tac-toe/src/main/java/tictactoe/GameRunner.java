package tictactoe;

import java.util.Scanner;

public class GameRunner {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] playerNames = requestForPlayerNames(input);

        TicTacToe ticTacToe = new TicTacToe(playerNames);
        printBoard(ticTacToe);
        do {
            try {
                Player currentPlayer = ticTacToe.currentPlayer();
                printCurrentPlayerTurn(currentPlayer);
                String location = input.nextLine();
                ticTacToe.take(location.charAt(0));
                printBoard(ticTacToe);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (!ticTacToe.gameIsOver());
    }

    private static String[] requestForPlayerNames(Scanner input) {
        System.out.println("1st player name: ");
        String firstPlayerName = input.nextLine();
        System.out.println("2nd player name: ");
        String secondPlayerName = input.nextLine();
        return new String[]{firstPlayerName, secondPlayerName};
    }

    private record Result(String firstPlayerName, String secondPlayerName) {
    }

    private static void printCurrentPlayerTurn(Player player) {
        System.out.println("%s's turn %s: ".formatted(player.name(), player.mark()));
    }

    private static void printBoard(TicTacToe ticTacToe) {
        System.out.println(ticTacToe);
    }
}
