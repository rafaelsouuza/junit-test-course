package io.github.rafaelsouuza.testcourse.resources;

import io.github.rafaelsouuza.testcourse.domain.User;
import io.github.rafaelsouuza.testcourse.domain.dto.UserDTO;
import io.github.rafaelsouuza.testcourse.services.impl.UserServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserResourceTest {

    @InjectMocks
    private UserResource resource;

    @Mock
    private ModelMapper mapper;

    @Mock
    private UserServiceImp service;

    private User user;
    private UserDTO userDTO;

    public static final Integer ID = 1;
    public static final String NAME = "Rafael";
    public static final String EMAIL = "rafael@mail.com";
    public static final String PASSWORD = "123";

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    private void startUser() {
        user = new User(ID, NAME, EMAIL, PASSWORD);
        userDTO = new UserDTO(ID, NAME, EMAIL, PASSWORD);
    }
}