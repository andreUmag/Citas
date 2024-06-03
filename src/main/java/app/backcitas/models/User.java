package app.backcitas.models;

import app.backcitas.Enum.IdentityDocumentType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private IdentityDocumentType identityDocumentType;
    private String idCard;

    @Column(unique = true)
    private String email;
    private String password;

    @ManyToOne
    @JoinColumn(name = "specialization_id")
    private Specialization specialization;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

}

