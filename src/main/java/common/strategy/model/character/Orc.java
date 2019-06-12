package common.strategy.model.character;

import common.strategy.model.behavior.*;
import utils.IOHelper;

public class Orc extends GameCharacter {

    Orc(){
        flyBehavior = FlyBehaviorFactory.getFlyBehavior(FlyBehaviors.NO_FLY);
        walkBehavior = WalkBehaviorFactory.getWalkBehavior(WalkBehaviors.TWO_LEGS_WALK);
        magicBehavior = MagicBehaviorFactory.getMagicBehavior(MagicBehaviors.NO_MAGIC);
    }

    @Override
    public void display() {
        new IOHelper(System.in, System.out).print( this + " is looking like a big muscle and savage orc!");
    }
}
