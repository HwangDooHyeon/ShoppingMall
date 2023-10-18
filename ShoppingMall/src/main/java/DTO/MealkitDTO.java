package DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MealkitDTO {

    MealkitDTO() {}

    private String MealName, MealCategory, MealInfo;

    private int MealPrice;

}