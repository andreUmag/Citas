package app.backcitas.models;

import app.backcitas.Enum.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "scheduled_appointments")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ScheduledAppointments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_doctor")
    private User doctor;

    @OneToOne
    @JoinColumn(name = "id_patient")
    private User patient;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dateTime;

    private Status status;

}
