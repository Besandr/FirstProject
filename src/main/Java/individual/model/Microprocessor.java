package individual.model;

public class Microprocessor {

    private WashingMachine machine;

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

    public void unlockTheDoor(){
        machine.getDoor().setLocked(false);
        System.out.println("The door is unlocked");
    }

    public void openPreWashingWaterFeedValve(){

        Valve waterFeedValve = machine.getPreWashingWaterFeedValve();

        waterFeedValve.setClosed(false);

    }

    public void closePreWashingWaterFeedValve(){

        Valve waterFeedValve = machine.getPreWashingWaterFeedValve();

        waterFeedValve.setClosed(true);

    }

    public void openWashingWaterFeedValve(){

        Valve waterFeedValve = machine.getWashingWaterFeedValve();

        waterFeedValve.setClosed(false);

    }

    public void closeWashingWaterFeedValve(){

        Valve waterFeedValve = machine.getWashingWaterFeedValve();

        waterFeedValve.setClosed(true);

    }

    public void openRinsingWaterFeedValve(){

        Valve waterFeedValve = machine.getRinsingWaterFeedValve();

        waterFeedValve.setClosed(false);

    }

    public void closeRinsingWaterFeedValve(){

        Valve waterFeedValve = machine.getRinsingWaterFeedValve();

        waterFeedValve.setClosed(true);

    }

    public void openDrainValve(){

        Valve drainValve = machine.getDrainValve();

        drainValve.setClosed(false);
    }

    public void closeDrainValve(){

        Valve drainValve = machine.getDrainValve();

        drainValve.setClosed(true);
    }

    public void startHeating(){

        WaterHeater heater = machine.getWaterHeater();

        heater.setHeating(true);

    }

    public void stopHeating(){

        WaterHeater heater = machine.getWaterHeater();

        heater.setHeating(false);
    }

    public void startMotor(RotationType type){

        Motor motor = machine.getMotor();

        motor.setCurrentMotorSpeed(type);
        System.out.println("Motor is running with speed: " + type.motorSpeed);

    }

    public void stopMotor(){

        Motor motor = machine.getMotor();

        motor.setCurrentMotorSpeed(RotationType.STOP);
        System.out.println("Motor is stopped");

    }

    public WashingMachine getMachine() {return machine;}

}
