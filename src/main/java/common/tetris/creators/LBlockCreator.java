package common.tetris.creators;

public class LBlockCreator implements Creator{

    @Override
    public Block createFigure() {
        int[][] jBlockData = new int[][]{{1,0},
                                         {1,0},
                                         {1,1}};
        return new LBlock(jBlockData);
    }
}
