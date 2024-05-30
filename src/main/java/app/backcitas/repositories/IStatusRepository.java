package app.backcitas.repositories;

import app.backcitas.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface IStatusRepository extends JpaRepository<Status, UUID> {
}
