package project.controller;

import org.springframework.web.bind.annotation.*;
import project.domen.Predmet;
import project.service.PredmetService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/predmeti")
public class PredmetController {
    private final PredmetService predmetService;

    public PredmetController(PredmetService predmetService) {
        this.predmetService = predmetService;
    }

    @GetMapping
    public List<Predmet> getAllPredmeti() {
        return predmetService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Predmet> getPredmetById(@PathVariable Long id) {
        return predmetService.findById(id);
    }

    @PostMapping
    public Predmet createPredmet(@RequestBody Predmet predmet) {
        return predmetService.save(predmet);
    }

    @DeleteMapping("/{id}")
    public void deletePredmet(@PathVariable Long id) {
        predmetService.delete(id);
    }
}

