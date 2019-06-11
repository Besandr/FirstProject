package common.tetris.creators;

public class SBlock implements Block {

    private int[][] figure;

    public SBlock(int[][] figure) {
        this.figure = figure;
    }

    @Override
    public String toString() {
        return "S-Block";
    }

    @Override
    public int[][] getFigure() {
        return figure;
    }
}
