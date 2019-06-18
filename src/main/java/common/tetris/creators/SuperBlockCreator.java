package common.tetris.creators;

public class SuperBlockCreator implements Creator {

    @Override
    public Block createFigure() {

        int blockIndex = (int) (Math.random() * (BlockTypes.values().length - 1));

        Block block = new BlockFactory().getBlock(BlockTypes.values()[blockIndex]);

        int[][] newFigure = getIncreasedBlock(block);

        block.setFigure(newFigure);

        return block;
    }

    int[][] getIncreasedBlock(Block block) {
        int[][] sourceFigure = block.getFigure();
        int[][] increasedFigure = new int[sourceFigure.length * 2][sourceFigure[0].length * 2];


        for (int i = 0; i < sourceFigure.length; i++) {
            for (int j = 0; j < sourceFigure[0].length; j++) {

                for (int m = 0; m < 2; m++) {
                    for (int n = 0; n < 2; n++) {
                        increasedFigure[i * 2 + m][j * 2 + n] = sourceFigure[i][j];
                    }
                }

            }
        }
        return increasedFigure;
    }

}
