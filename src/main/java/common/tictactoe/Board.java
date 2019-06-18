package common.tictactoe;

class Board {

    private char[][] boardArr;
    private int turnCounter = 0;
    private boolean isGameOver;
    private String winner;

    private Memento lastTurn;

    Board(){
        init();
    }

    private void init() {
        boardArr = new char[3][3];
        for (int i = 0; i < boardArr.length; i++) {
            for (int j = 0; j < boardArr.length; j++) {
                boardArr[i][j] = ' ';
            }
        }
    }

    char[][] getBoardArr() {
        return boardArr;
    }

    boolean performTurn(int i, int j, char c) {

        if (boardArr[i][j] == ' ') {

            if (c == 'X') {
                lastTurn = new Memento(boardArr);
            }

            boardArr[i][j] = c;
            turnCounter++;
            checkEndGame(c);

            return true;
        } else {
            return false;
        }
    }

    void undoTurn(){
        boardArr = lastTurn.getSavedBoard();
    }

    private void checkEndGame(char c){
        boolean endGame = false;
        for (int k = 0; k < 8; k++) {
            // Checking rows
            if (boardArr[0][0] == c && boardArr[0][1] == c && boardArr[0][2] == c){
                endGame = true;
                break;
            }
            if (boardArr[1][0] == c && boardArr[1][1] == c && boardArr[1][2] == c){
                endGame = true;
                break;
            }
            if (boardArr[2][0] == c && boardArr[2][1] == c && boardArr[2][2] == c){
                endGame = true;
                break;
            }

            // Checking columns
            if (boardArr[0][0] == c && boardArr[1][0] == c && boardArr[2][0] == c){
                endGame = true;
                break;
            }
            if (boardArr[0][1] == c && boardArr[1][1] == c && boardArr[2][1] == c){
                endGame = true;
                break;
            }
            if (boardArr[0][2] == c && boardArr[1][2] == c && boardArr[2][2] == c){
                endGame = true;
                break;
            }

            // Checking diagonals
            if (boardArr[0][0] == c && boardArr[1][1] == c && boardArr[2][2] == c){
                endGame = true;
                break;
            }
            if (boardArr[0][2] == c && boardArr[1][1] == c && boardArr[2][0] == c){
                endGame = true;
                break;
            }
        }

        if (endGame) {
            isGameOver = true;
            winner = c == 'X' ? "User" : "AI";
        }
    }

    int getTurnCounter() {
        return turnCounter;
    }

    boolean isGameOver() {
        return isGameOver;
    }

    String getWinner() {
        return winner;
    }
}
