package project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Predmet>> getAllPredmeti() {
        List<Predmet> predmeti = predmetService.findAll();
        return ResponseEntity.ok(predmeti);  // Status 200 OK
    }

    @GetMapping("/{id}")
    public ResponseEntity<Predmet> getPredmetById(@PathVariable Long id) {
        Optional<Predmet> predmet = predmetService.findById(id);
        return predmet.map(ResponseEntity::ok)  // Ako predmet postoji, vrati 200 OK
                .orElseGet(() -> ResponseEntity.notFound().build());  // Ako predmet ne postoji, vrati 404 Not Found
    }

    @PostMapping
    public ResponseEntity<Predmet> createPredmet(@RequestBody Predmet predmet) {
        Predmet createdPredmet = predmetService.save(predmet);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPredmet);  // Status 201 Created
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePredmet(@PathVariable Long id) {
        if (predmetService.findById(id).isPresent()) {
            predmetService.delete(id);
            return ResponseEntity.noContent().build();  // Status 204 No Content (success, no response body)
        } else {
            return ResponseEntity.notFound().build();  // Status 404 Not Found (predmet doesn't exist)
        }
    }
}
