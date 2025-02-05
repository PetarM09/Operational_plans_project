package project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.domen.MesecniPlan;
import project.domen.DetaljiPlana;
import project.security.CheckSecurity;
import project.service.MesecniPlanService;
import project.service.FajlService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/mesecni-plan")
public class MesecniPlanController {
    private final MesecniPlanService mesecniPlanService;
    private final FajlService fajlService;

    public MesecniPlanController(MesecniPlanService mesecniPlanService, FajlService fajlService) {
        this.mesecniPlanService = mesecniPlanService;
        this.fajlService = fajlService;
    }

    @PostMapping("/hello")
    public ResponseEntity<String> hello(@RequestBody String name) {
        return ResponseEntity.ok("Hello, " + name);
    }

    @CheckSecurity(roles = {"ADMIN"})
    @PostMapping("/generisi")
    public ResponseEntity<String> generisiMesecniPlan(@RequestHeader("Authorization") String authorization, @RequestBody MesecniPlan mesecniPlan) {
        List<DetaljiPlana> detaljiPlana = mesecniPlanService.getDetaljiPlana(mesecniPlan);

        try {
            String fileName = fajlService.generateWord(mesecniPlan, detaljiPlana);
            return ResponseEntity.ok("Dokument je uspešno generisan: " + fileName);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Greška prilikom generisanja dokumenta");
        }
    }
}
