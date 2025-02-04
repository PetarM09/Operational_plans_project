package project.domen;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Getter
@Setter
public class MesecniPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int mesec;
    private int godina;

    @ManyToOne
    @JoinColumn(name = "predmet_id")
    private Predmet predmet;

    @ManyToOne
    @JoinColumn(name = "godina_id")
    private GodinaSkolovanja godinaSkolovanja;

    @ManyToOne
    @JoinColumn(name = "profesor_id")
    private User profesor;
}
