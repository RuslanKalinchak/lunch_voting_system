package kalinchak.exam.lunch_voting_system.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "FOODS")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "FOOD_ID")
    private Long foodId;

    @Column(name = "FOOD_NAME")
    private String foodName;

    @Column(name = "FOOD_PRICE")
    private Long price;

    @ManyToOne
    @JoinColumn(name = "MENU_ID")
    private Menu menu;
}
