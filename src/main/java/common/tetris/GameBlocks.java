package common.tetris;

import common.tetris.creators.*;

import java.util.ArrayList;
import java.util.List;

class GameBlocks {

    private List<Block> blockList;

    GameBlocks() {
        init();
    }

    private void init(){

        blockList = new ArrayList<>();
        blockList.add(new IBlockCreator().createFigure());
        blockList.add(new OBlockCreator().createFigure());
        blockList.add(new JBlockCreator().createFigure());
        blockList.add(new LBlockCreator().createFigure());
        blockList.add(new TBlockCreator().createFigure());
        blockList.add(new SBlockCreator().createFigure());
        blockList.add(new ZBlockCreator().createFigure());

    }

    void addBlock(Block block){
        blockList.add(block);
    }

    List<Block> getBlockList(){
        return blockList;
    }
}
