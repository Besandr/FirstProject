package common.strategy.model.character;

public class CharacterFactory {
    public static GameCharacter getCharacter(CharacterTypes type) {
        switch (type) {
            case ORC:
                return new Orc();
            case HARPY:
                return new Harpy();
            case PEGASUS:
                return new Pegasus();
            case ELF:
                return new Elf();
            default:
                throw new IllegalArgumentException("There is no such type of character " + type);
        }
    }
}
