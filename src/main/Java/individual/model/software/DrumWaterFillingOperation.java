package individual.model.software;

import individual.model.Drum;
import individual.model.WashingMachine;

public abstract class DrumWaterFillingOperation extends SubProgram {

    WashingMachine machine;

    DrumWaterFillingOperation(MicroOS microOs) {
        super(microOs);
        machine = microOs.getMicroprocessor().getMachine();
    }

    @Override
    public void execute(Instruction instruction) {

        Drum drum = machine.getDrum();

        if (!drum.isWaterFilled()) {

            openWaterFeedValve();

            System.out.println("Filling the drum with water");

            try{
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
                closeWaterFeedValve();
                throw new IllegalStateException("The drum water filling is canceled");
            }

            closeWaterFeedValve();

            drum.setWaterFilled(true);

            machine.getTemperatureSensor().resetTemperatureToTapWaterTemp();

            setDetergentAsUsed();

        }

        System.out.println("Drum is filled");
    }

    protected abstract void setDetergentAsUsed();

    protected abstract void closeWaterFeedValve();

    protected abstract void openWaterFeedValve();




}
