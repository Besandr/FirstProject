package common.flightweight;

public class Report {

    private String bacteriumName;
    private int breedingTime;
    private  int temperature;
    private  long colonyPopulation;

    Report(String bacteriumName, int temperature, int breedingTime, long colonyPopulation) {
        this.bacteriumName = bacteriumName;
        this.breedingTime = breedingTime;
        this.temperature = temperature;
        this.colonyPopulation = colonyPopulation;
    }

    @Override
    public String toString() {
        return "Report{" +
                "bacteriumName='" + bacteriumName + '\'' +
                ", breedingTime=" + breedingTime +
                ", temperature=" + temperature +
                ", colonyPopulation=" + colonyPopulation +
                '}';
    }
}
