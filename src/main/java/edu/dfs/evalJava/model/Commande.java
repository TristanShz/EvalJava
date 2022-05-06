package edu.dfs.evalJava.model;

import com.fasterxml.jackson.annotation.JsonView;
import edu.dfs.evalJava.views.AffichageCommande;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date datePaiement;

    @ManyToOne
    @JsonView(AffichageCommande.class)
    private Utilisateur client;

    @OneToMany(mappedBy = "commande")
    @JsonView(AffichageCommande.class)
    private Set<LigneCommande> listeLigneCommande = new HashSet<>();
}
