package kalinchak.exam.lunch_voting_system.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "VOTING_SYSTEM", schema = "mysqldb")
@Setter
@Getter
@NoArgsConstructor
public class Voting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "VOTING_ID")
    private Long id;

    @Column(name = "VOTING_DATE")
    private LocalDateTime date;

    @OneToOne
    @JoinColumn(name = "MENU_ID")
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
}
