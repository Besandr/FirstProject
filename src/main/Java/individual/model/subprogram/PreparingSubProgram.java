package individual.model.subprogram;

import individual.model.Microprocessor;
import individual.model.Program;

public class PreparingSubProgram extends SubProgram {

    public PreparingSubProgram(Microprocessor microprocessor) {
        super(microprocessor);
    }

    @Override
    public boolean execute(Program program) {

       return microprocessor.lockTheDoor();

    }
}
