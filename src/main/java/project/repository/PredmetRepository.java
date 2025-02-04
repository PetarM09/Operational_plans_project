package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.domen.Predmet;

public interface PredmetRepository extends JpaRepository<Predmet, Long> {}
