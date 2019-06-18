package common.tictactoe;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Game {

    Board board;
    private Scanner scanner;

    Game(){
        board = new Board();
        scanner = new Scanner(System.in);
    }

    void printBoard(){
        char[][] currentBoard = board.getBoardArr();
        System.out.println("  0 1 2");
        System.out.println("________");

        for (int i = 0; i < currentBoard.length; i++) {
            System.out.print(i + "|");
            for (int j = 0; j < currentBoard.length; j++) {
                System.out.print(currentBoard[i][j] + "|");
            }
            System.out.println("\n________");
//            System.out.println();
        }
    }

    void userTurn(){
        System.out.println("Make you turn by typing coordinates or type \"undo\" for cancelling last turn.");
        System.out.println("Example for middle bottom cell: 1, 2");

        while(true) {

            String line = scanner.nextLine();
            if (line.contains("undo")) {

                System.out.println("You choose undo");
                System.out.println("Roll back the game");

                board.undoTurn();
                printBoard();
                userTurn();
                return;

            } else {
                Pattern pattern = Pattern.compile("\\D*([0-2]).+([0-2])");
                Matcher matcher = pattern.matcher(line);

                int i = -1;
                int j = -1;

                if (matcher.find()) {
                    i = Integer.parseInt(matcher.group(2));
                    j = Integer.parseInt(matcher.group(1));
                } else {
                    System.out.println("Enter valid coordinates");
                }

                if (i > -1) {
                    if (board.performTurn(i, j, 'X')) {
                        break;
                    } else {
                        System.out.println("Choose unoccupied cell");
                    }
                }
            }
        }
    }

    void aiTurn(){
        int i, j;
        do {
            int rand = (int) (Math.random() * 9);
            i = rand / 3;
            j = rand % 3;
        } while (!board.performTurn(i, j, 'O'));

        printBoard();
    }

}
