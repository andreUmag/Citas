package app.backcitas.repositories;

import app.backcitas.models.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SpecializationRepository extends JpaRepository<Specialization, Long> {
}
