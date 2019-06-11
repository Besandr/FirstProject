package common.tetris.creators;

public class LBlock implements Block{

    private int[][] figure;

    public LBlock(int[][] figure) {
        this.figure = figure;
    }

    @Override
    public String toString() {
        return "L-Block";
    }

    @Override
    public int[][] getFigure() {
        return figure;
    }
}
