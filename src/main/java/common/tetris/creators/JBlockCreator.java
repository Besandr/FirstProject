package common.tetris.creators;

public class JBlockCreator implements Creator {
    @Override
    public Block createFigure() {
        int[][] jBlockData = new int[][]{{0,1},
                                         {0,1},
                                         {1,1}};
        return new JBlock(jBlockData);
    }
}
