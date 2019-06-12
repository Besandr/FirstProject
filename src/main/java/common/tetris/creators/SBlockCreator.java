package common.tetris.creators;

public class SBlockCreator implements Creator {

    @Override
    public Block createFigure() {
        int[][] oBlockData = new int[][]{{0,1,1},
                                         {1,1,0}};
        return new SBlock(oBlockData);
    }
}
