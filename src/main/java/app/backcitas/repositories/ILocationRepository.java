package app.backcitas.repositories;

import app.backcitas.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ILocationRepository extends JpaRepository<Location, UUID> {
}
