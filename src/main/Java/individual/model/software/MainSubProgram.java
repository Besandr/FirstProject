package individual.model.software;

public class MainSubProgram extends SubProgram {

    MainSubProgram(MicroOS microOs) {
        super(microOs);
    }

    @Override
    public void execute(Instruction instruction) {

        if (instruction.IS_ACTIVE) {

            if (isNeedWaterFilling(instruction)) {
                microOs.getWaterFillingOperation(instruction).execute(instruction);
            }

            microOs.heat(instruction.WATER_TEMP);

            if (instruction.currentType == Instruction.TYPE.SPINNING) {

                microOs.spinTheDrum(instruction.MOTOR_ROTATION_TYPE, instruction.ROTATION_TIME);

            } else {

                microOs.runMotor(instruction.MOTOR_ROTATION_TYPE, instruction.ROTATION_TIME);

                microOs.drainTheDrum();
            }
        }
    }
}
