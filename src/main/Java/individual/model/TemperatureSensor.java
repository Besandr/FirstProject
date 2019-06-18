package individual.model;

public class TemperatureSensor {

    private final int DEFAULT_TEMPERATURE = 16;

    private int currentTemperature;

    TemperatureSensor(){
        resetTemperatureToTapWaterTemp();
    }

    public void resetTemperatureToTapWaterTemp(){
        currentTemperature = DEFAULT_TEMPERATURE;
    }

    public int getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(int currentTemperature) {
        this.currentTemperature = currentTemperature;
    }
}
