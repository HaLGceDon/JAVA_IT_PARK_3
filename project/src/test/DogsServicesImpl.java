package ru.itpark.services;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

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
