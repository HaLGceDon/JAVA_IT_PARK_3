package ru.itpark.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.itpark.models.user.User;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {

        List<User> findByOrderByRegistrationTimeDesc();
        List<User> findByOrderById();
        List<User> findByOrderByName();

        Optional<User> findByConfirmCode(String confirmCode);
        Optional<User> findByPasswordRecoveryCode(String code);
        Optional<User> findByLogin(String login);
        Optional<User> findByEmail(String email);
}
