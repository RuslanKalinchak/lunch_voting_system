package kalinchak.exam.lunch_voting_system.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table (name = "RESTAURANTS", schema ="mysqldb")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESTAURANT_ID")
    private Long restaurantId;

    @Column(name = "RESTAURANT_NAME")
    private String restaurantName;

    @OneToMany(mappedBy = "restaurant")
    private Set<Menu> menu;
}
