package app.backcitas.repositories;

import app.backcitas.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ILocationRepository extends JpaRepository<Location, UUID> {
}
