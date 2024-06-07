package app.backcitas.repositories;



import app.backcitas.models.ScheduledAppointments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduledAppointmentsRepository extends JpaRepository<ScheduledAppointments, Long> {
    List<ScheduledAppointments> findScheduledAppointmentsByPatient_Id(Long idPatient);
}
