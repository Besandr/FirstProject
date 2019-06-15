package individual.model;

class TemperatureSensor {

    private final int DEFAULT_TEMPERATURE = 18;

    private int currentTemperature;

    TemperatureSensor(){
        resetTemperatureToTapWater();
    }

    private void resetTemperatureToTapWater(){
        currentTemperature = DEFAULT_TEMPERATURE;
    }

    int getCurrentTemperature() {
        return currentTemperature;
    }

    void setCurrentTemperature(int currentTemperature) {
        this.currentTemperature = currentTemperature;
    }
}
