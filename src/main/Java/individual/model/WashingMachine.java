package individual.model;

import individual.model.software.MicroOS;
import individual.view.ControlPanel;

public class WashingMachine {

    private Motor motor;
    private Drum drum;
    private Door door;
    private DetergentDrawer detergentDrawer;
    private ControlPanel controlPanel;
    private Valve drainValve;
    private Valve preWashingWaterFeedValve;
    private Valve washingWaterFeedValve;
    private Valve rinsingWaterFeedValve;
    private TemperatureSensor temperatureSensor;
    private WaterHeater waterHeater;

    public WashingMachine() {
        motor = new Motor();
        drum = new Drum();
        door = new Door();
        detergentDrawer = new DetergentDrawer();
        drainValve = new Valve();
        preWashingWaterFeedValve = new Valve();
        washingWaterFeedValve = new Valve();
        rinsingWaterFeedValve = new Valve();
        temperatureSensor = new TemperatureSensor();
        waterHeater = new WaterHeater();
        Microprocessor microprocessor = new Microprocessor(this);
        MicroOS microOS = new MicroOS(this, microprocessor);
        controlPanel = new ControlPanel(microOS);
    }

    public TemperatureSensor getTemperatureSensor() {
        return temperatureSensor;
    }

    WaterHeater getWaterHeater() {
        return waterHeater;
    }

    Door getDoor() {
        return door;
    }

    Valve getPreWashingWaterFeedValve() {
        return preWashingWaterFeedValve;
    }

    Valve getWashingWaterFeedValve() {
        return washingWaterFeedValve;
    }

    Valve getRinsingWaterFeedValve() {
        return rinsingWaterFeedValve;
    }

    Motor getMotor() {
        return motor;
    }

    public DetergentDrawer getDetergentDrawer() {
        return detergentDrawer;
    }

    public Drum getDrum() {
        return drum;
    }

    Valve getDrainValve() {
        return drainValve;
    }

    public void plugIn(){

        controlPanel.showInterface();

    }

    public boolean isLaundryLoaded() {
        return drum.isLoaded();
    }

    public boolean loadLaundry(){

        if (!drum.isLoaded() && door.isOpened() && !door.isLocked()) {

            drum.setLoaded(true);
            return true;

        } else {

            return false;

        }
    }

    public boolean unloadLaundry() {

        if (drum.isLoaded() && door.isOpened() && !door.isLocked()) {

            drum.setLoaded(false);
            return true;

        } else {

            return false;
        }
    }

    public boolean isDoorOpened(){
        return door.isOpened();
    }

    public boolean openDoor(){
        if (door.isLocked()) {
            return false;
        } else {

            door.setOpened(true);
            return true;
        }
    }

    public void closeDoor(){
        door.setClosed();
    }
}
