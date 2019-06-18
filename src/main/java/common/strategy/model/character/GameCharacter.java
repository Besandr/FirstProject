package common.strategy.model.character;

import common.strategy.model.behavior.FlyBehavior;
import common.strategy.model.behavior.MagicBehavior;
import common.strategy.model.behavior.WalkBehavior;

import java.util.ArrayList;
import java.util.List;

public abstract class GameCharacter {

    WalkBehavior walkBehavior;
    FlyBehavior flyBehavior;
    MagicBehavior magicBehavior;

    List<GameCharacter> party;

    protected GameCharacter(){
        resetParty();
    }

    void resetParty(){
        party = new ArrayList<>();
        party.add(this);
    }

    public void addPartyMember(GameCharacter character) {
        party.add(character);
    }

    public void setWalkBehavior(WalkBehavior walkBehavior) {
        this.walkBehavior = walkBehavior;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setMagicBehavior(MagicBehavior magicBehavior) {
        this.magicBehavior = magicBehavior;
    }

    public void performWalk(){
        walkBehavior.walk();
    }

    public void performFly(){
        flyBehavior.fly();
    }

    public void performMagic() {
        party.forEach(c -> magicBehavior.cast(c));
    }

    public abstract void display();

    @Override
    public String toString(){
        return getClass().getSimpleName();
    }

}
