package common.tetris.creators;

class IBlock implements Block {

    private int[][] figure;

    public IBlock(int[][] figure) {
        this.figure = figure;
    }

    @Override
    public String toString() {
        return "I-Block";
    }

    @Override
    public int[][] getFigure() {
        return figure;
    }
}
