package common.recipe;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;

public class RecipeDemo {

    public static void main(String[] args) {
        new RecipeDemo().go();
    }

    public void go(){

        HashMap<String, Integer> drugList = new HashMap<>();
        drugList.put("Aspirin", 10);
        drugList.put("Analgin", 20);
        drugList.put("Amphetamine", 1);
        LocalDate expiredDate = LocalDate.now().plusDays(14);

        Recipe recipe = new PhysicianRecipe("Mr.House", expiredDate, "Depression", drugList);
        System.out.println("Recipe for " + recipe.getPatientName() + " will be expired on:");
        System.out.println(recipe.getExpiredDate());

        recipe = new ProlongedRecipe(recipe, recipe.getExpiredDate().plusDays(14));
        System.out.println("After prolongation recipe for " + recipe.getPatientName() + " will be expired on:");
        System.out.println(recipe.getExpiredDate());
    }
}
