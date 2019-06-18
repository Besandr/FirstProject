package common.strategy.model.behavior;

import utils.IOHelper;

public class NoFly implements FlyBehavior {
    @Override
    public void fly() {
        new IOHelper(System.in, System.out).print("I can't fly :(");
    }
}
