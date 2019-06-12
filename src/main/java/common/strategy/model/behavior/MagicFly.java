package common.strategy.model.behavior;

import utils.IOHelper;

public class MagicFly implements FlyBehavior {
    @Override
    public void fly() {
        new IOHelper(System.in, System.out).print("is performing magic fly!");
    }
}
