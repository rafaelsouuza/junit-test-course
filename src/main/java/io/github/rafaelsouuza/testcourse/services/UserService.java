package io.github.rafaelsouuza.testcourse.services;

import io.github.rafaelsouuza.testcourse.domain.User;
import io.github.rafaelsouuza.testcourse.domain.dto.UserDTO;

import java.util.List;

public interface UserService {

    User findById(Integer id);
    List<User> findAll();
    User create(UserDTO obj);
    User update(UserDTO obj);
    void delete(Integer id);
}
