package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.domen.DetaljiPlana;
import project.domen.MesecniPlan;
import project.domen.User;

import java.util.List;

public interface DetaljiPlanaRepository extends JpaRepository<DetaljiPlana, Long> {
    public List<DetaljiPlana> findByMesecniPlan(MesecniPlan  mesecniPlan);
}