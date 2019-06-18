package individual.model.software;

import individual.model.*;
import individual.model.software.service.ProgramsLoader;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class MicroOS {

    private PropertyChangeSupport propertyChangeSupport;

    private WashingMachine machine;
    private Microprocessor microprocessor;

    private List<Program> programs;
    private int chosenProgramIndex;

    private ProgramExecutor programExecutor;

    public MicroOS(WashingMachine machine, Microprocessor microprocessor) {

        this.machine = machine;
        this.microprocessor = microprocessor;

        propertyChangeSupport = new PropertyChangeSupport(this);

        programs = new ProgramsLoader().loadPrograms("src/main/resources/programs.xml");
        chosenProgramIndex = programs.size() - 1;

        programExecutor = new ProgramExecutor(this);
    }

    public String setNextProgram(){
        chosenProgramIndex = ++chosenProgramIndex % programs.size();
        return chosenProgramIndex + 1 + ". " + programs.get(chosenProgramIndex).NAME;
    }

    void heat(int targetTemperature) {

        TemperatureSensor temperatureSensor = machine.getTemperatureSensor();

        System.out.println("Target temp: " + targetTemperature + ". heating ...");

        int currentTemp = temperatureSensor.getCurrentTemperature();

        if (currentTemp < targetTemperature) {
            microprocessor.startHeating();
        }

        while (currentTemp < targetTemperature) {

            try{
                Thread.sleep(100);
            } catch (InterruptedException ignored) {
                microprocessor.stopHeating();
                throw new IllegalStateException("Heating is canceled");
            }

            currentTemp++;
        }

        temperatureSensor.setCurrentTemperature(currentTemp);
        microprocessor.stopHeating();

        System.out.println("Water is heated");

    }

    void runMotor(RotationType type, int runningTime) {

        microprocessor.startMotor(type);

        try {

            Thread.sleep(runningTime);

        } catch (InterruptedException ignored) {

            throw new IllegalStateException("The motor running is canceled");

        } finally {
            microprocessor.stopMotor();
        }
    }

    void drainTheDrum(){

        Drum drum = machine.getDrum();

        if (drum.isWaterFilled()) {

            microprocessor.openDrainValve();
            System.out.println("Drum is draining");

            try{

                Thread.sleep(1000);

            } catch (InterruptedException e) {

                throw new IllegalStateException("The draining operation is canceled");

            } finally {

                microprocessor.closeDrainValve();
                System.out.println("Drum is drained");

                drum.setWaterFilled(false);

            }
        }
    }

    void spinTheDrum(RotationType type, int spinningTime) {

        microprocessor.openDrainValve();

        System.out.println("Spinning the drum with speed: " + type.motorSpeed);
        runMotor(type, spinningTime);

        microprocessor.closeDrainValve();

    }

    DrumWaterFillingOperation getWaterFillingOperation(Instruction instruction) {
        switch (instruction.currentType) {
            case PRE_WASHING:
                return new PreWashingWaterFillingOperation(this);
            case WASHING:
                return new WashingWaterFillingOperation(this);
            case RINSING:
                return new RinsingWaterFillingOperation(this);
            default:
                throw new UnsupportedOperationException("Unsupported water filling operation");
        }
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        propertyChangeSupport.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        propertyChangeSupport.removePropertyChangeListener(pcl);
    }

    public boolean prepareWashing(){
        return microprocessor.lockTheDoor();
    }

    public void startWashing(){

        programExecutor.start();

    }

    public void cancelWashing(){

        if (programExecutor.isAlive()) {
            programExecutor.interrupt();
            programExecutor = new ProgramExecutor(this);
        }

        drainTheDrum();
        microprocessor.unlockTheDoor();
    }

    public int getProgramTime(){

        final int WATER_FILLING_TIME = 1000;
        final int WATER_DRAINING_TIME = 1000;

        int totalTime = 0;

        for (Instruction instruction : programs.get(chosenProgramIndex).INSTRUCTIONS_SET) {

            if (instruction.IS_ACTIVE) {

                totalTime += instruction.ROTATION_TIME;

                if (instruction.currentType != Instruction.TYPE.SPINNING) {

                    int currentTemp = machine.getTemperatureSensor().getCurrentTemperature();
                    int targetTemp = instruction.WATER_TEMP;

                    int heatingTime = targetTemp > currentTemp ? (targetTemp - currentTemp) * 100 : 0;

                    totalTime += WATER_FILLING_TIME + heatingTime + WATER_DRAINING_TIME;

                }
            }
        }

        return totalTime;
    }

    class ProgramExecutor extends Thread{

        MicroOS microOS;

        ProgramExecutor(MicroOS microOS) {
            this.microOS = microOS;
        }

        @Override
        public void run(){

            try {

                for (Instruction instruction : programs.get(chosenProgramIndex).INSTRUCTIONS_SET) {
                    propertyChangeSupport.firePropertyChange("operation", null, instruction.currentType.toString());
                    new MainSubProgram(microOS).execute(instruction);
                }

                microprocessor.unlockTheDoor();

                programExecutor = new ProgramExecutor(microOS);

                propertyChangeSupport.firePropertyChange("complete", null, null);

            } catch (IllegalStateException e) {
                System.out.println(e);

            }
        }
    }

    public Microprocessor getMicroprocessor() {
        return microprocessor;
    }
}
