package edu.dfs.evalJava.controller;

import com.fasterxml.jackson.annotation.JsonView;
import edu.dfs.evalJava.dao.CommandeDao;
import edu.dfs.evalJava.model.Commande;
import edu.dfs.evalJava.views.AffichageCommande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class CommandeController {

    private CommandeDao commandeDao;

    @Autowired
    public CommandeController(CommandeDao commandeDao) {
        this.commandeDao = commandeDao ;
    }
    @GetMapping("/liste-commande")
    @JsonView(AffichageCommande.class)
    public List<Commande> commandes() {
        return commandeDao.findAll();
    }
}
