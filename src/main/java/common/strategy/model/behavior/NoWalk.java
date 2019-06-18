package common.strategy.model.behavior;

import utils.IOHelper;

public class NoWalk implements WalkBehavior {
    @Override
    public void walk() {
        new IOHelper(System.in, System.out).print("I can't walking :(");
    }
}
