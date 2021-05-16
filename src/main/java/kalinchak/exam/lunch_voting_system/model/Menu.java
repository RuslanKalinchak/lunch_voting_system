package kalinchak.exam.lunch_voting_system.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "MENU", schema = "mysqldb")
@Setter
@Getter
@NoArgsConstructor
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MENU_ID")
    private Long id;

    @Column(name = "MENU_NAME")
    private String menuName;

    @Column(name = "MENU_DATE")
    private LocalDateTime date;

    @OneToMany(mappedBy = "menu")
    private Set<Food> foods;

    @ManyToOne
    @JoinColumn(name = "RESTAURANT_ID")
    private Restaurant restaurant;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Voting voting;
}
