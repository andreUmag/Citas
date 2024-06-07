package app.backcitas.models;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "status")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "status")
    private List<ScheduledAppointments> scheduledAppointments;
}
