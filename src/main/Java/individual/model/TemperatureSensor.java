package individual.model;

class TemperatureSensor {

    private final int DEFAULT_TEMPERATURE = 16;

    private int currentTemperature;

    TemperatureSensor(){
        resetTemperatureToTapWaterTemp();
    }

    void resetTemperatureToTapWaterTemp(){
        currentTemperature = DEFAULT_TEMPERATURE;
    }

    int getCurrentTemperature() {
        return currentTemperature;
    }

    void setCurrentTemperature(int currentTemperature) {
        this.currentTemperature = currentTemperature;
    }
}
