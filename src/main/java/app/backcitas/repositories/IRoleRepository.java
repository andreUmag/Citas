package app.backcitas.repositories;

import app.backcitas.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IRoleRepository extends JpaRepository<Role, UUID> {
}
