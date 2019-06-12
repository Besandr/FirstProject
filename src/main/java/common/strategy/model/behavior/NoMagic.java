package common.strategy.model.behavior;

import common.strategy.model.character.GameCharacter;
import utils.IOHelper;

public class NoMagic implements MagicBehavior {

    @Override
    public void cast(GameCharacter character) {
        new IOHelper(System.in, System.out).print("I haven't got magic skills :(");
    }
}
