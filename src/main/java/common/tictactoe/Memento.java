package common.tictactoe;

import java.util.Arrays;

public class Memento {

    private char[][] savedBoard;

    Memento(char[][] board) {
        savedBoard = Arrays.stream(board).map(r -> r.clone()).toArray(char[][]::new);
    }

    public char[][] getSavedBoard() {
        return savedBoard;
    }

}
