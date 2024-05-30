package app.backcitas.repositories;

import app.backcitas.models.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ISpecializationRepository extends JpaRepository<Specialization, UUID> {
}
