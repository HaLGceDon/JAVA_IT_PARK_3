package ru.itpark.services;

import java.util.List;

public interface DogsServices {
    List<Dog> getDogs (String orderBy);
}
