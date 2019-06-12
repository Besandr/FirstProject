package common.strategy.model.behavior;

public class FlyBehaviorFactory {

    public static FlyBehavior getFlyBehavior(FlyBehaviors flyBehavior) {
        switch (flyBehavior) {
            case NO_FLY:
                return new NoFly();
            case MAGIC_FLY:
                return new MagicFly();
            case WINGS_FLY:
                return new WingsFly();
            default:
                throw new IllegalArgumentException("There is no such type of fly behavior " + flyBehavior);
        }
    }
}
