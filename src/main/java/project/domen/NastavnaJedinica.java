package project.domen;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Getter
@Setter
public class NastavnaJedinica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String naziv;

    @ManyToOne
    @JoinColumn(name = "tema_id", nullable = true)
    private Tema tema;

    @ManyToOne
    @JoinColumn(name = "oblast_id")
    private Oblast oblast;
}