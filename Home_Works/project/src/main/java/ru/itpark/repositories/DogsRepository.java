package ru.itpark.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itpark.models.Dog;

public interface DogsRepository extends JpaRepository <Dog, Long> {
}
