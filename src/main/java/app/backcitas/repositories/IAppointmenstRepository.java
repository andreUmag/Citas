package app.backcitas.repositories;

import app.backcitas.models.Appointmenst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface IAppointmenstRepository extends JpaRepository<Appointmenst, UUID> {
}
