package individual.model.subprogram;

import individual.model.DetergentDrawer;
import individual.model.Microprocessor;
import individual.model.Program;

public class WashingSubProgram extends SubProgram {

    public WashingSubProgram(Microprocessor microprocessor) {
        super(microprocessor);
    }

    @Override
    public boolean execute(Program program) {

        microprocessor.fillDrumWithWater(DetergentDrawer.DetergentType.MAIN_WASH);
        microprocessor.heat(program.WASHING_TEMPERATURE);
        microprocessor.runMotor(program.WASHING_ROTATING_TYPE, program.WASHING_TIME);
        microprocessor.drainTheDrum(true);

        return true;
    }
}
