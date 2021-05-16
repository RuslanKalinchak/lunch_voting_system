package kalinchak.exam.lunch_voting_system.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "RESTAURANTS", schema = "mysqldb")
@Setter
@Getter
@NoArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESTAURANT_ID")
    private Long id;

    @Column(name = "RESTAURANT_NAME")
    private String restaurantName;

    @OneToMany(mappedBy = "restaurant")
    private Set<Menu> menu;
}
