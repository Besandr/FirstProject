package common.strategy.model.behavior;

import utils.IOHelper;

public class TwoLegsWalk implements WalkBehavior {
    @Override
    public void walk() {
        new IOHelper(System.in, System.out).print("is walking with normal speed");
    }
}
