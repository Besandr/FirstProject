package common.tetris.creators;

public class ZBlockCreator implements Creator {

    @Override
    public Block createFigure() {
        int[][] oBlockData = new int[][]{{1,1,0},
                {0,1,1}};
        return new ZBlock(oBlockData);
    }
}
