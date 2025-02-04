package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.domen.Tema;

public interface TemaRepository extends JpaRepository<Tema, Long> {}

