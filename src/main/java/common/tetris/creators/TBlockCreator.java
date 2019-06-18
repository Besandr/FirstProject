package common.tetris.creators;

public class TBlockCreator implements Creator {

    @Override
    public Block createFigure() {
        int[][] oBlockData = new int[][]{{0,1,0},
                                         {1,1,1}};
        return new TBlock(oBlockData);
    }
}
