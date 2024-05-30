package app.backcitas.repositories;

import app.backcitas.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface IUserRepository extends JpaRepository<User, UUID> {

}