package common.tetris.creators;

public class OBlockCreator implements Creator {

    @Override
    public Block createFigure() {
        int[][] oBlockData = new int[][]{{1,1},
                                         {1,1}};
        return new OBlock(oBlockData);
    }
}
