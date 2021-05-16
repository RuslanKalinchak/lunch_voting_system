package kalinchak.exam.lunch_voting_system.model;

import lombok.Data;

import java.util.List;

@Data
public class MenuDto {
    private Long menuId;
    private String menuName;
    private List<FoodDto> foods;
}
