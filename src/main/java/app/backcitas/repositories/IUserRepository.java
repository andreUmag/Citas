package app.backcitas.repositories;

import app.backcitas.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface IUserRepository extends JpaRepository<User, UUID> {

}
