package individual.model;

class WaterHeater {

    private TemperatureSensor sensor;

    WaterHeater(TemperatureSensor sensor){
        this.sensor = sensor;
    }

    void heat(int targetTemperature) {

        int currentTemp = sensor.getCurrentTemperature();

        while (currentTemp < targetTemperature) {

            try{
                Thread.sleep(100);
            } catch (InterruptedException ignored) {}

            currentTemp++;
        }

        sensor.setCurrentTemperature(currentTemp);
    }

}
