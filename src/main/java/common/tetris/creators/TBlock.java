package common.tetris.creators;

public class TBlock implements Block{

    private int[][] figure;

    public TBlock(int[][] figure) {
        this.figure = figure;
    }

    @Override
    public String toString() {
        return "T-Block";
    }

    @Override
    public int[][] getFigure() {
        return figure;
    }
}
