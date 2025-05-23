package org.example.modelcontextprotocoleapi.repository;
import org.example.modelcontextprotocoleapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

}
