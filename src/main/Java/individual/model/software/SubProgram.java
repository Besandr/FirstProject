package individual.model.software;

public abstract class SubProgram {

    MicroOS microOs;

    SubProgram(MicroOS microOs) {
        this.microOs = microOs;
    }

    public abstract void execute(Instruction instruction);

    boolean isNeedWaterFilling(Instruction instruction) {
        return !(instruction.currentType == Instruction.TYPE.SPINNING);
    }

}
