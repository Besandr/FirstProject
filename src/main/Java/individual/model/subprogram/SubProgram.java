package individual.model.subprogram;

import individual.model.Microprocessor;
import individual.model.Program;

public abstract class SubProgram {

    Microprocessor microprocessor;

    public SubProgram(Microprocessor microprocessor) {
        this.microprocessor = microprocessor;
    }

    public abstract boolean execute(Program program);

}
