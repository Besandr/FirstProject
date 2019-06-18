package common.strategy.model.behavior;

import utils.IOHelper;

public class FourLegsWalk implements WalkBehavior {
    @Override
    public void walk() {
        new IOHelper(System.in, System.out).print("is walking with fast speed");
    }
}
