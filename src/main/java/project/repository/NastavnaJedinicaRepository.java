package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.domen.NastavnaJedinica;

public interface NastavnaJedinicaRepository extends JpaRepository<NastavnaJedinica, Long> {}
