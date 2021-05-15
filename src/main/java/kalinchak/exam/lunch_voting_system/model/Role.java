package kalinchak.exam.lunch_voting_system.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ROLES")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "ROLE_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
}