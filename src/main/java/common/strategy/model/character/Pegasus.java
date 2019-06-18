package common.strategy.model.character;

import common.strategy.model.behavior.*;
import utils.IOHelper;

public class Pegasus extends GameCharacter {

    Pegasus(){
        flyBehavior = FlyBehaviorFactory.getFlyBehavior(FlyBehaviors.WINGS_FLY);
        walkBehavior = WalkBehaviorFactory.getWalkBehavior(WalkBehaviors.FOUR_LEGS_WALK);
        magicBehavior = MagicBehaviorFactory.getMagicBehavior(MagicBehaviors.NO_MAGIC);
    }

    @Override
    public void display() {
        new IOHelper(System.in, System.out).print( this + " is looking like a beautiful horse with silver wings");
    }
}
