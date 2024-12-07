package nl.novi.techiteasy.services;

import nl.novi.techiteasy.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;

@Service
public class TelevisionService {
    private final TelevisionRepository televisionRepository;

    public TelevisionService(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }
}