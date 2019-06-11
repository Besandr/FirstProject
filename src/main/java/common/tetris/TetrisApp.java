package common.tetris;

import common.tetris.creators.Block;
import utils.IOHelper;
import utils.UserInteractingHelper;

import java.util.List;

public class TetrisApp {

    enum CreationWay {RANDOM, MANUAL}

    public static void main(String[] args) {
        new TetrisApp().go();
    }

    public void go(){

        IOHelper ioHelper = new IOHelper(System.in, System.out);
        UserInteractingHelper userInteractingHelper = new UserInteractingHelper(ioHelper);
        GameBlocks gameBlocks = new GameBlocks();

        CreationWay creationWay = offerCreationVariants(ioHelper, userInteractingHelper);

        Block block = null;
        List<Block> blockList = gameBlocks.getBlockList();
        switch (creationWay) {
            case RANDOM:
                block = randomBlockCreation(blockList);
                break;
            case MANUAL:
                block = manualBlockCreation(blockList, ioHelper, userInteractingHelper);
                break;
        }

        printFigure(block, ioHelper);
    }

    Block randomBlockCreation(List<Block> blockList) {

        int blockIndex = (int) (Math.random() * blockList.size());

        return blockList.get(blockIndex);
    }

    Block manualBlockCreation(List<Block> blockList, IOHelper ioHelper, UserInteractingHelper userInteractingHelper) {

        ioHelper.print("Choose block: ");


        for (int i = 0; i < blockList.size(); i++) {
            ioHelper.inLinePrint(i + 1 + ". ");
            ioHelper.print(blockList.get(i));
        }

        int blockIndex = userInteractingHelper.takeUserChoice(1, blockList.size()) - 1;

        return blockList.get(blockIndex);
    }

    CreationWay offerCreationVariants(IOHelper ioHelper, UserInteractingHelper userInteractingHelper) {

        ioHelper.print("Select block-creation way:");

        CreationWay[] creationWays = CreationWay.values();

        for (int i = 0; i < creationWays.length; i++) {
            ioHelper.inLinePrint(i + 1 + ". ");
            ioHelper.print(creationWays[i]);
        }

        int wayChoice = userInteractingHelper.takeUserChoice(1, creationWays.length) - 1;

        return creationWays[wayChoice];
    }

    void printFigure(Block block, IOHelper ioHelper) {

        int[][] chosenFigure = block.getFigure();
        for (int i = 0; i < chosenFigure.length; i++) {
            for (int j = 0; j < chosenFigure[0].length; j++) {

                ioHelper.inLinePrint(getFigureChar(chosenFigure[i][j]));
            }

            ioHelper.print("");
        }
    }

    char getFigureChar(int code) {
        if (code == 1) {
            return '#';
        } else {
            return ' ';
        }
    }
}
