package app.backcitas.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "eps")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EPS {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "eps")
    private List<User> Users;
}
