package common.strategy.model.character;

import common.strategy.model.behavior.*;
import utils.IOHelper;

public class Harpy extends GameCharacter {

    Harpy (){
        flyBehavior = FlyBehaviorFactory.getFlyBehavior(FlyBehaviors.WINGS_FLY);
        walkBehavior = WalkBehaviorFactory.getWalkBehavior(WalkBehaviors.NO_WALK);
        magicBehavior = MagicBehaviorFactory.getMagicBehavior(MagicBehaviors.NO_MAGIC);
    }

    @Override
    public void display() {
        new IOHelper(System.in, System.out).print( this + " is looking like a big bird with a female face");
    }
}
