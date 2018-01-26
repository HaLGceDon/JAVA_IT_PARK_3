package ru.itpark.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.itpark.models.User;

public interface UsersRepository extends JpaRepository<User, Long> {
}