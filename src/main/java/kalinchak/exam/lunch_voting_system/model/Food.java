package kalinchak.exam.lunch_voting_system.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "FOODS", schema = "mysqldb")
@Setter
@Getter
@NoArgsConstructor
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
