package project.domen;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Getter
@Setter
public class DetaljiPlana {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "plan_id")
    private MesecniPlan plan;

    @ManyToOne
    @JoinColumn(name = "nastavna_jedinica_id")
    private NastavnaJedinica nastavnaJedinica;

    @ManyToOne
    @JoinColumn(name = "ishod_id")
    private IshodUcenja ishod;

    @ManyToOne
    @JoinColumn(name = "metod_id")
    private MetodaOblikRada metodaOblikRada;
}