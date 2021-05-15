package kalinchak.exam.lunch_voting_system.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table (name = "restaurants")
@Setter
@Getter
@NoArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "restaurant_id")
    private Long restaurantId;

    @Column(name = "restaurant_name")
    private String restaurantName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    private Set<Menu> menu;
}
