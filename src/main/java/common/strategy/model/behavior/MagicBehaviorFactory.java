package common.strategy.model.behavior;

public class MagicBehaviorFactory {

    public static MagicBehavior getMagicBehavior(MagicBehaviors behavior) {
        switch (behavior) {
            case NO_MAGIC:
                return new NoMagic();
            case FLY_MAGIC:
                return new FlyMagic();
            default:
                throw new IllegalArgumentException("There is no such type of magic behavior " + behavior);
        }
    }
}
