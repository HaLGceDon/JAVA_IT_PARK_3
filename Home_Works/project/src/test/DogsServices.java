package ru.itpark.service;

import ru.itpark.models.Dog;

import java.util.List;

public interface DogsServices {
    List<Dog> getDogs (String orderBy);
}
