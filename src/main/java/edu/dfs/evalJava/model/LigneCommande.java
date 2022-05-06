package edu.dfs.evalJava.model;

import com.fasterxml.jackson.annotation.JsonView;
import edu.dfs.evalJava.views.AffichageCommande;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class LigneCommande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonView(AffichageCommande.class)
    private Integer quantite;

    @ManyToOne
    private Commande commande;

    @ManyToOne
    @JsonView(AffichageCommande.class)
    private Article article;
}
