package io.github.rafaelsouuza.testcourse.services.impl;

import io.github.rafaelsouuza.testcourse.domain.User;
import io.github.rafaelsouuza.testcourse.domain.dto.UserDTO;
import io.github.rafaelsouuza.testcourse.repositories.UserRepository;
import io.github.rafaelsouuza.testcourse.services.UserService;
import io.github.rafaelsouuza.testcourse.services.exceptions.ObjectNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {

    private UserRepository repository;
    private ModelMapper mapper;

    @Override
    public User findById(Integer id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User create(UserDTO obj) {
        return repository.save(mapper.map(obj, User.class));
    }
}
