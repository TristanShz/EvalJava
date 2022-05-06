package edu.dfs.evalJava.model;

import com.fasterxml.jackson.annotation.JsonView;
import edu.dfs.evalJava.model.Article;
import edu.dfs.evalJava.model.Utilisateur;
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
public class Employe extends Utilisateur {
    @JsonView(AffichageEmploye.class)
    private boolean administrateur;

    @OneToMany(mappedBy = "gestionnaire")
    @JsonView({AffichageEmploye.class})
    private Set<Article> listeArticleAgerer = new HashSet<>();
}