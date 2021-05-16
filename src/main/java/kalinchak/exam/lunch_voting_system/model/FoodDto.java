package kalinchak.exam.lunch_voting_system.model;

import lombok.Data;

@Data
public class FoodDto {
    private Long foodId;
    private String foodName;
    private Long price;
}
