package OBJ;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Mealkit {

    String MealName, MealCategory, MealInfo;
    int MealPrice;

    @Builder
    public Mealkit(long id, String mealName, String mealCategory, String mealPrice, String mealInfo) {
        this.MealName = MealName;
        this.MealCategory = MealCategory;
        this.MealInfo = MealInfo;
        this.MealPrice = MealPrice;
    }
}
