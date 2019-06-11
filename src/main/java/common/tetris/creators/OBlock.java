package common.tetris.creators;

class OBlock implements Block {

    private int[][] figure;

    public OBlock(int[][] figure) {
        this.figure = figure;
    }

    @Override
    public String toString() {
        return "O-Block";
    }

    @Override
    public int[][] getFigure() {
        return figure;
    }
}
