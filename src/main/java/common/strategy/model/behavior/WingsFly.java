package common.strategy.model.behavior;

import utils.IOHelper;

public class WingsFly implements FlyBehavior {
    @Override
    public void fly() {
        new IOHelper(System.in, System.out).print("is flying with wings");
    }
}
