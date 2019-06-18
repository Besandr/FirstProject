package common.strategy.model.behavior;

import common.strategy.model.character.GameCharacter;
import utils.IOHelper;

public class FlyMagic implements MagicBehavior {
    @Override
    public void cast(GameCharacter character) {
        new IOHelper(System.in, System.out).print("casting fly spell on " + character + "!");
        character.setFlyBehavior(FlyBehaviorFactory.getFlyBehavior(FlyBehaviors.MAGIC_FLY));
    }
}
