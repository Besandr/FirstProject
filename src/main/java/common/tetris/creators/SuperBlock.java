package common.tetris.creators;

public class SuperBlock implements Block {

    private int[][] figure;

    public SuperBlock(int[][] figure) {
        this.figure = figure;
    }

    @Override
    public String toString() {
        return "Super-Block";
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
