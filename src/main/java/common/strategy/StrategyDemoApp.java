package common.strategy;

import common.strategy.model.character.CharacterFactory;
import common.strategy.model.character.CharacterTypes;
import common.strategy.model.character.GameCharacter;
import utils.IOHelper;

import java.util.ArrayList;

public class StrategyDemoApp {

    public static void main(String[] args) {
        new StrategyDemoApp().go();
    }

    public void go() {

        IOHelper ioHelper = new IOHelper(System.in, System.out);

        printPlan(ioHelper);

        // 1 step
        ArrayList<GameCharacter> characters = createCharacters();

        // 2 step
        displayCharacters(characters, ioHelper);

        // 3 step
        moveCharacters(characters, ioHelper);

        // 4 step
        castFlySpell(characters, ioHelper);

        // 5 step
        performFly(characters, ioHelper);

        ioHelper.print("=====================\n");
        ioHelper.print("The end of demo. Thank you for watching");

    }

    void printPlan(IOHelper ioHelper) {

        ioHelper.print("1. Create orc, pegasus, elf and harpy");
        ioHelper.print("2. Display each one");
        ioHelper.print("3. Try to perform fly and walk by each character");
        ioHelper.print("4. Cast elf's fly spell on created characters group");
        ioHelper.print("5. Try again to perform fly by each character");
        ioHelper.input("Press <Enter> to start...");
    }

    ArrayList<GameCharacter> createCharacters(){

        ArrayList<GameCharacter> characters = new ArrayList<>();

        characters.add(CharacterFactory.getCharacter(CharacterTypes.ORC));
        characters.add(CharacterFactory.getCharacter(CharacterTypes.HARPY));
        characters.add(CharacterFactory.getCharacter(CharacterTypes.PEGASUS));
        characters.add(CharacterFactory.getCharacter(CharacterTypes.ELF));

        return characters;
    }

    void moveCharacters(ArrayList<GameCharacter> characters, IOHelper ioHelper) {

        ioHelper.print("=================================\n");
        ioHelper.print("3nd step\n");

        characters.forEach(c -> {
            ioHelper.inLinePrint(c.getClass().getSimpleName() + ": ");
            c.performWalk();
        });

        ioHelper.print("\n");

        characters.forEach(c -> {
            ioHelper.inLinePrint(c.getClass().getSimpleName() + ": ");
            c.performFly();
        });
    }

    void displayCharacters(ArrayList<GameCharacter> characters, IOHelper ioHelper) {

        ioHelper.print("=================================\n");
        ioHelper.print("2rd step\n");

        characters.forEach(c -> c.display());
    }

    void castFlySpell(ArrayList<GameCharacter> characters, IOHelper ioHelper) {

        ioHelper.print("=================================\n");
        ioHelper.print("4th step\n");

        GameCharacter elf = characters.get(3);
        for (int i = 0; i < characters.size() - 1; i++) {
            elf.addPartyMember(characters.get(i));
        }

        elf.performMagic();
    }

    void performFly(ArrayList<GameCharacter> characters, IOHelper ioHelper) {
        ioHelper.print("=================================\n");
        ioHelper.print("5th step\n");

        characters.forEach(c -> {
            ioHelper.inLinePrint(c.getClass().getSimpleName() + ": ");
            c.performFly();
        });
    }



}
