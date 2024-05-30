package app.backcitas.repositories;

import app.backcitas.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IStatusRepository extends JpaRepository<Status, UUID> {
}
