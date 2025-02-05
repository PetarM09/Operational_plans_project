package project.service;

import org.springframework.stereotype.Service;
import project.domen.MesecniPlan;
import project.domen.DetaljiPlana;
import project.repository.MesecniPlanRepository;
import project.repository.DetaljiPlanaRepository;

import java.util.List;

@Service
public class MesecniPlanService {

    private final MesecniPlanRepository mesecniPlanRepository;
    private final DetaljiPlanaRepository detaljiPlanaRepository;

    public MesecniPlanService(MesecniPlanRepository mesecniPlanRepository, DetaljiPlanaRepository detaljiPlanaRepository) {
        this.mesecniPlanRepository = mesecniPlanRepository;
        this.detaljiPlanaRepository = detaljiPlanaRepository;
    }
    public List<MesecniPlan> findAll() {
        return mesecniPlanRepository.findAll();
    }
    public MesecniPlan findById(Long id) {
        return mesecniPlanRepository.findById(id).orElse(null);
    }

    public List<DetaljiPlana> getDetaljiPlana(MesecniPlan mesecniPlan) {
        return detaljiPlanaRepository.findByMesecniPlan(mesecniPlan);
    }
}
