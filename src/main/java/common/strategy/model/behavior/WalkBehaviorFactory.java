package common.strategy.model.behavior;

public class WalkBehaviorFactory {

    public static WalkBehavior getWalkBehavior(WalkBehaviors walkBehavior) {
        switch (walkBehavior) {
            case NO_WALK:
                return new NoWalk();
            case TWO_LEGS_WALK:
                return new TwoLegsWalk();
            case FOUR_LEGS_WALK:
                return new FourLegsWalk();
            default:
                throw new IllegalArgumentException("There is no such type of walk behavior " + walkBehavior);
        }
    }
}
