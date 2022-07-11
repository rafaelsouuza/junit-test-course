package io.github.rafaelsouuza.testcourse.services;

import io.github.rafaelsouuza.testcourse.domain.User;

import java.util.List;

public interface UserService {

    User findById(Integer id);
    List<User> findAll();
}
