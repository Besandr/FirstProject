package individual.model;

import individual.model.subprogram.*;

import java.util.ArrayList;
import java.util.List;

public class Microprocessor {

    WashingMachine machine;

    List<SubProgram> taskProcedure;

    Indicator indicator;

    Microprocessor(WashingMachine machine) {
        this.machine = machine;
    }


    public boolean lockTheDoor(){
        Door door = machine.getDoor();

        if (door.isOpened()) {
            return false;
        } else {
            door.setLocked(true);
            System.out.println("Door is locked");
            return true;
        }
    }

    public boolean unlockTheDoor(){
        machine.getDoor().setLocked(false);
        System.out.println("The door is unlocked");
        return true;
    }

    public boolean fillDrumWithWater(DetergentDrawer.DetergentType detergentType){

        Drum drum = machine.getDrum();

        if (!drum.isWaterFilled()) {

            Valve waterFeedValve = machine.getWaterFeedValve();
            DetergentDrawer detergentDrawer = machine.getDetergentDrawer();

            waterFeedValve.setClosed(false);
            detergentDrawer.useDetergent(detergentType);

            System.out.println("Filling the drum with water");

            try{
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {}

            machine.getTemperatureSensor().resetTemperatureToTapWaterTemp();

            drum.setWaterFilled(true);

        }

        return true;
    }

    public boolean heat(int targetTemperature) {

        TemperatureSensor temperatureSensor = machine.getTemperatureSensor();
        WaterHeater heater = machine.getWaterHeater();
        System.out.println("Target temp: " + targetTemperature + ". heating ...");

        int currentTemp = temperatureSensor.getCurrentTemperature();

        if (currentTemp < targetTemperature) {
            heater.setHeating(true);
        }

        while (currentTemp < targetTemperature) {

            try{
                Thread.sleep(100);
            } catch (InterruptedException ignored) {}

            currentTemp++;
        }

        temperatureSensor.setCurrentTemperature(currentTemp);
        heater.setHeating(false);

        return true;
    }

    public boolean runMotor(RotatingType type, int runningTime) {

        Motor motor = machine.getMotor();

        motor.setCurrentMotorSpeed(type);
        System.out.println("Motor is running with speed: " + type.getMotorSpeed());

        try {
            Thread.sleep(runningTime);
        } catch (InterruptedException ignored) {}

        motor.setCurrentMotorSpeed(RotatingType.STOP);
        System.out.println("Motor is stopped");

        return true;
    }

    public boolean drainTheDrum(boolean withSpinning){

        Drum drum = machine.getDrum();

        if (drum.isWaterFilled()) {

            Valve drainValve = machine.getDrainValve();
            drainValve.setClosed(false);
            System.out.println("Drum is draining");

            if (withSpinning) {
                spinTheDrum(RotatingType.LOW_SPINNING, 2000);
            }

            drainValve.setClosed(true);
            drum.setWaterFilled(false);
            System.out.println("Drum is drained");
        }

        return true;
    }

    public boolean spinTheDrum(RotatingType type, int spinningTime) {

        Valve drainValve = machine.getDrainValve();

        if (drainValve.isClosed()) {
            drainValve.setClosed(false);
        }

        System.out.println("Spinning the drum with speed: " + type.getMotorSpeed());
        runMotor(type, spinningTime);

        drainValve.setClosed(true);

        return true;
    }

    void test(){

        Program normal = new Program(true, 40, RotatingType.NORMAL, RotatingType.MIDDLE_SPINNING);

        taskProcedure = new ArrayList<>();
        taskProcedure.add(new PreparingSubProgram(this));
        taskProcedure.add(new PreWashingSubProgram(this));
        taskProcedure.add(new WashingSubProgram(this));
        taskProcedure.add(new SpinningSubProgram(this));
        taskProcedure.add(new FinishingSubProgram(this));

        boolean isExecutingTaskSuccessful = true;

        for (SubProgram subProgram : taskProcedure) {
            if (!subProgram.execute(normal)) {
                isExecutingTaskSuccessful = false;
                break;
            }
        }

        if (!isExecutingTaskSuccessful) {
            System.out.println("Can't execute task");
            new CancelingSubProgram(this).execute(null);
        }
    }

    public static void main(String[] args) {
        WashingMachine machine = new WashingMachine();

        machine.getMicroprocessor().test();
    }
}
