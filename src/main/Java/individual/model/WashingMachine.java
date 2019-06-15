package individual.model;

public class WashingMachine {

    private Motor motor;
    private Drum drum;
    private Door door;
    private DetergentDrawer detergentDrawer;
    private ControlPanel controlPanel;
    private Microprocessor microprocessor;
    private Valve drainValve;
    private Valve waterFeedValve;
    private TemperatureSensor temperatureSensor;
    private WaterHeater waterHeater;

    public WashingMachine() {
        motor = new Motor();
        drum = new Drum();
        door = new Door();
        detergentDrawer = new DetergentDrawer();
        controlPanel = new ControlPanel();
        drainValve = new Valve();
        waterFeedValve = new Valve();
        temperatureSensor = new TemperatureSensor();
        waterHeater = new WaterHeater();
        microprocessor = new Microprocessor(this);
    }


    public TemperatureSensor getTemperatureSensor() {
        return temperatureSensor;
    }

    public WaterHeater getWaterHeater() {
        return waterHeater;
    }

    public Door getDoor() {
        return door;
    }

    public Valve getWaterFeedValve() {
        return waterFeedValve;
    }

    public Motor getMotor() {
        return motor;
    }

    public DetergentDrawer getDetergentDrawer() {
        return detergentDrawer;
    }

    public Drum getDrum() {
        return drum;
    }

    public ControlPanel getControlPanel() {
        return controlPanel;
    }

    public Microprocessor getMicroprocessor() {
        return microprocessor;
    }

    public Valve getDrainValve() {
        return drainValve;
    }
}
