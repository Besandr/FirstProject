package common.strategy.model.character;

import common.strategy.model.behavior.*;
import utils.IOHelper;

public class Elf extends GameCharacter {

    Elf(){
        flyBehavior = FlyBehaviorFactory.getFlyBehavior(FlyBehaviors.NO_FLY);
        walkBehavior = WalkBehaviorFactory.getWalkBehavior(WalkBehaviors.TWO_LEGS_WALK);
        magicBehavior = MagicBehaviorFactory.getMagicBehavior(MagicBehaviors.FLY_MAGIC);
    }

    @Override
    public void display() {
        new IOHelper(System.in, System.out).print( this + " is looking like a tall perfect human bean which is full of magic and centuries wisdom");
    }




}
