package app.backcitas.repositories;

import app.backcitas.models.Appointmenst;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IAppointmenstRepository extends JpaRepository<Appointmenst, UUID> {

}
