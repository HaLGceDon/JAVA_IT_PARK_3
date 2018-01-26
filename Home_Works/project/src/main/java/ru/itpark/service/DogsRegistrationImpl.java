package ru.itpark.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itpark.forms.DogsForm;
import ru.itpark.models.Dog;
import ru.itpark.repositories.DogsRepository;


@Service
public class DogsRegistrationImpl implements RegistrationService <DogsForm> {

    @Autowired
    private DogsRepository dogsRepository;



    @Override
    public Long registration(DogsForm form) {
        Dog newDog = Dog.builder()
                .name(form.getName())
                .age(form.getAge())
                .color(form.getColor())
                .breed(form.getBreed())
                .weight(form.getWeight())
                .health(form.getHealth())
                .build();

        dogsRepository.save(newDog);
        return newDog.getId();
    }
}
