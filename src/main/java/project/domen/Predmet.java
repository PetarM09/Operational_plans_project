package project.domen;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Getter
@Setter
public class Predmet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String naziv;

    @ManyToOne
    @JoinColumn(name = "godina_id")
    private GodinaSkolovanja godina;
}