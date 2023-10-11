package DTO;

import OBJ.Mealkit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MealkitDTO {

    MealkitDTO() {}

    private String MealName, MealCategory, MealInfo;
    private int MealPrice;

}
