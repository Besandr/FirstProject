package common.tictactoe;

public class Demo {
    public static void main(String[] args) {
        new Demo().go();
    }

    public void go(){
        Game game = new Game();

        String winner = "";

        int turnCounter = 0;
        while (turnCounter < 9) {
            turnCounter = game.board.getTurnCounter();

            if (turnCounter % 2 == 0) {
                game.userTurn();
            } else {
                game.aiTurn();
            }

            if (game.board.isGameOver()) {
                winner = game.board.getWinner();
                break;
            }
        }

        if (winner.isEmpty()) {
            System.out.println("The game is over. No one wins");
        } else {
            System.out.println("The " + winner + " win!");
            game.printBoard();
        }
    }
}
