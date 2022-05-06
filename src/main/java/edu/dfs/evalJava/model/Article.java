package edu.dfs.evalJava.model;

import com.fasterxml.jackson.annotation.JsonView;
import edu.dfs.evalJava.views.AffichageCommande;
import edu.dfs.evalJava.views.AffichageEmploye;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonView({AffichageEmploye.class})
    private String nom;

    @JsonView(AffichageCommande.class)
    private float prix;

    @ManyToOne
    private Employe gestionnaire;

    @ManyToMany
    @JoinTable(
            name = "caracteristique",
            joinColumns =  @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "propriete_id")
    )
    @JsonView(AffichageCommande.class)
    private List<Propriete> listeCaracteristique = new ArrayList<>();
}
