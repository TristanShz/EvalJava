package edu.dfs.evalJava.model;

import com.fasterxml.jackson.annotation.JsonView;
import edu.dfs.evalJava.views.AffichageCommande;
import edu.dfs.evalJava.views.AffichageEmploye;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(AffichageEmploye.class)
    private Integer id;

    @JsonView({AffichageEmploye.class, AffichageCommande.class})
    private String login;

    private String password;

    @ManyToMany
    private Set<MoyenPaiement> listeMoyenPaiement = new HashSet<>();

    @OneToMany(mappedBy = "client")
    private Set<Commande> listeCommande = new HashSet<>();
}
