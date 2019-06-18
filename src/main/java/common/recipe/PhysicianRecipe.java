package common.recipe;

import java.time.LocalDate;
import java.util.HashMap;

final public class PhysicianRecipe implements Recipe{

    private final String patientName;
    private final String diagnosis;
    private final LocalDate expiredDate;
    private final HashMap<String, Integer> drugList;

    PhysicianRecipe(String patientName, LocalDate expiredDate, String diagnosis, HashMap<String, Integer> drugList) {
        this.patientName = patientName;
        this.expiredDate = expiredDate;
        this.diagnosis = diagnosis;
        this.drugList = drugList;
    }

    @Override
    public LocalDate getExpiredDate() {
        return expiredDate;
    }

    @Override
    public String getPatientName() {
        return patientName;
    }

    @Override
    public String getDiagnosis() {
        return diagnosis;
    }

    @Override
    public HashMap<String, Integer> getDrugList() {
        return drugList;
    }
}
