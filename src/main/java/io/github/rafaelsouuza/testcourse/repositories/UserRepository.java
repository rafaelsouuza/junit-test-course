package io.github.rafaelsouuza.testcourse.repositories;

import io.github.rafaelsouuza.testcourse.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
