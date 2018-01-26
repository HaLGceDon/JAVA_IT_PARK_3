package ru.itpark.service;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import ru.itpark.models.Dog;
        import ru.itpark.repositories.DogsRepository;

        import java.util.List;

@Service
public class DogsServicesImpl implements DogsServices {

    @Autowired
    private DogsRepository dogsRepository;


    @Override
    public List<Dog> getDogs(String orderBy) {
        return dogsRepository.findAll();
    }
}
