package common.tetris.creators;

class JBlock implements Block {
    private int[][] figure;

    public JBlock(int[][] figure) {
        this.figure = figure;
    }

    @Override
    public String toString() {
        return "J-Block";
    }

    @Override
    public int[][] getFigure() {
        return figure;
    }
}
