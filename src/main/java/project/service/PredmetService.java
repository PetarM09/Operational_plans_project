package project.service;

import org.springframework.stereotype.Service;
import project.domen.Predmet;
import project.repository.PredmetRepository;

import java.util.List;
import java.util.Optional;
@Service
public class PredmetService {
    private final PredmetRepository predmetRepository;

    public PredmetService(PredmetRepository predmetRepository) {
        this.predmetRepository = predmetRepository;
    }

    public List<Predmet> findAll() {
        return predmetRepository.findAll();
    }

    public Optional<Predmet> findById(Long id) {
        return predmetRepository.findById(id);
    }

    public Predmet save(Predmet predmet) {
        return predmetRepository.save(predmet);
    }

    public void delete(Long id) {
        predmetRepository.deleteById(id);
    }
}
