package io.github.rafaelsouuza.testcourse.services;

import io.github.rafaelsouuza.testcourse.domain.User;

public interface UserService {

    User findById(Integer id);
}
