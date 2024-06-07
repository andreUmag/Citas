package app.backcitas.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "identity_document_type")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IdentityDocumentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "documentType")
    private List<User> Users;
}
