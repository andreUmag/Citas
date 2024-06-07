package app.backcitas.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "appointments_available")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AppointmentAvailable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "id_doctor")
    private User doctor;

    private Boolean available;

}
