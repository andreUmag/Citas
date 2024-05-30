package app.backcitas.repositories;

import app.backcitas.models.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ISpecializationRepository extends JpaRepository<Specialization, UUID> {
}
