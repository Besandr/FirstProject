package common.tetris.creators;

public class IBlockCreator implements Creator {


    @Override
    public Block createFigure() {
        int[][] iBlockData = new int[][]{{1,1,1,1,1}};
        return new IBlock(iBlockData);
    }
}
