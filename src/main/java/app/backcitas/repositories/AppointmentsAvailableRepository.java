package app.backcitas.repositories;

import app.backcitas.models.AppointmentAvailable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AppointmentsAvailableRepository extends JpaRepository<AppointmentAvailable, Long> {
}
