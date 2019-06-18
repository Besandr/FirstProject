package common.recipe;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;

public class ProlongedRecipe implements Recipe {

    private Recipe baseRecipe;
    private final LocalDate newExpiredDate;

    ProlongedRecipe(Recipe baseRecipe, LocalDate newExpiredDate) {
        this.baseRecipe = baseRecipe;
        this.newExpiredDate = newExpiredDate;
    }

    @Override
    public String getPatientName() {
        return baseRecipe.getPatientName();
    }

    @Override
    public String getDiagnosis() {
        return baseRecipe.getDiagnosis();
    }

    @Override
    public LocalDate getExpiredDate() {
        return newExpiredDate;
    }

    @Override
    public HashMap<String, Integer> getDrugList() {
        return baseRecipe.getDrugList();
    }
}
