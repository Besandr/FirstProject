package common.tetris.creators;

public class ZBlock implements Block {

    private int[][] figure;

    public ZBlock(int[][] figure) {
        this.figure = figure;
    }

    @Override
    public String toString() {
        return "Z-Block";
    }

    @Override
    public int[][] getFigure() {
        return figure;
    }

    @Override
    public void setFigure(int[][] figure) {
        this.figure = figure;
    }
}
