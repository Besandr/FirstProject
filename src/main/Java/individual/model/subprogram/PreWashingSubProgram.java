package individual.model.subprogram;

import individual.model.DetergentDrawer;
import individual.model.Microprocessor;
import individual.model.Program;

public class PreWashingSubProgram extends SubProgram {


    public PreWashingSubProgram(Microprocessor microprocessor) {
        super(microprocessor);
    }

    @Override
    public boolean execute(Program program) {

        if (program.NEED_PRE_WASHING) {
            microprocessor.fillDrumWithWater(DetergentDrawer.DetergentType.PRE_WASH);
            microprocessor.heat(program.PRE_WASHING_TEMP);
            microprocessor.runMotor(program.PRE_WASHING_ROTATING, program.PRE_WASHING_TIME);
            microprocessor.drainTheDrum(true);
        }

        return true;
    }


}
