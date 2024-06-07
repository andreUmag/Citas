package app.backcitas.repositories;

import app.backcitas.models.AppointmentAvailable;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AppointmentsAvailableRepository extends JpaRepository<AppointmentAvailable, Long> {
    List<AppointmentAvailable> findByDoctor_Specialization_Name(String specialization);
}
