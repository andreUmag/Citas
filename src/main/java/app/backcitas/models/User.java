package app.backcitas.models;
import app.backcitas.dtos.Eps;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombreAndApellido;
    private Integer cedula;
    private Eps eps;
    @Column(unique = true)
    private String email;
    private String password;
    private String role;
}
