package individual.model.subprogram;

import individual.model.Microprocessor;
import individual.model.Program;

public class CancelingSubProgram extends SubProgram {

    public CancelingSubProgram(Microprocessor microprocessor) {
        super(microprocessor);
    }

    @Override
    public boolean execute(Program program) {
        return false;
    }
}
