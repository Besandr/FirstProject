package individual.model.subprogram;

import individual.model.Microprocessor;
import individual.model.Program;

public class SpinningSubProgram extends SubProgram {

    public SpinningSubProgram(Microprocessor microprocessor) {
        super(microprocessor);
    }

    @Override
    public boolean execute(Program program) {

        microprocessor.spinTheDrum(program.SPINNING_ROTATING_TYPE, program.SPINNING_TIME);

        return true;
    }
}
