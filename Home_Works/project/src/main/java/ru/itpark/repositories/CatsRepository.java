package ru.itpark.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itpark.models.Cat;

public interface CatsRepository extends JpaRepository <Cat, Long> {
}
