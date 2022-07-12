package io.github.rafaelsouuza.testcourse.repositories;

import io.github.rafaelsouuza.testcourse.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
