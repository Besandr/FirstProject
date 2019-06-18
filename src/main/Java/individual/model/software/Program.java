package individual.model.software;

import java.util.SortedSet;

public class Program {

    final String NAME;

    final SortedSet<Instruction> INSTRUCTIONS_SET;

    public Program(String NAME, SortedSet<Instruction> INSTRUCTIONS_SET) {
        this.NAME = NAME;
        this.INSTRUCTIONS_SET = INSTRUCTIONS_SET;
    }
}
