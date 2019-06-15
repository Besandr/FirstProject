package individual.model.subprogram;

import individual.model.Microprocessor;
import individual.model.Program;

public class FinishingSubProgram extends SubProgram {

    public FinishingSubProgram(Microprocessor microprocessor) {
        super(microprocessor);
    }

    @Override
    public boolean execute(Program program) {

        microprocessor.unlockTheDoor();

        return true;
    }
}
