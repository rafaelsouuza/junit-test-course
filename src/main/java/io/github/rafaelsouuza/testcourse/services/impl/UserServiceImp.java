package io.github.rafaelsouuza.testcourse.services.impl;

import io.github.rafaelsouuza.testcourse.domain.User;
import io.github.rafaelsouuza.testcourse.domain.dto.UserDTO;
import io.github.rafaelsouuza.testcourse.repositories.UserRepository;
import io.github.rafaelsouuza.testcourse.services.UserService;
import io.github.rafaelsouuza.testcourse.services.exceptions.DataIntegratyViolationException;
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
        findByEmail(obj);
        return repository.save(mapper.map(obj, User.class));
    }

    @Override
    public User update(UserDTO obj) {
        findByEmail(obj);
        return repository.save(mapper.map(obj, User.class));
    }

    private void findByEmail(UserDTO obj) {
        Optional<User> user = repository.findByEmail(obj.getEmail());
        if (user.isPresent() && !user.get().getId().equals(obj.getId())) {
            throw new DataIntegratyViolationException("E-mail já cadastrado no sistema");
        }
    }
}
