package project.domen;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class PredmetIshod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ishod_id")
    private IshodUcenja ishod;

    @ManyToOne
    @JoinColumn(name = "predmet_id")
    private Predmet predmet;

    @ManyToOne
    @JoinColumn(name = "godina_id")
    private GodinaSkolovanja godina;
}