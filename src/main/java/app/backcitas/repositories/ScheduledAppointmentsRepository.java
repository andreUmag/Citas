package app.backcitas.repositories;


import app.backcitas.models.ScheduledAppointments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduledAppointmentsRepository extends JpaRepository<ScheduledAppointments, Long> {
}
