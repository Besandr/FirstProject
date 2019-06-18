package common.recipe;

import java.time.LocalDate;
import java.util.HashMap;

public interface Recipe {

    String getPatientName();

    String getDiagnosis();

    LocalDate getExpiredDate();

    HashMap<String, Integer> getDrugList();

}
