package app.backcitas.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "appointmensts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Appointmenst {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private LocalDateTime date;
    @ManyToOne
    private User doctor;
    @ManyToOne
    private User patient;
    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;
    @JoinColumn(name = "specialization_id", referencedColumnName = "id")
    private Specialization specialization;
}
