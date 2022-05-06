package edu.dfs.evalJava.controller;

import edu.dfs.evalJava.dao.EmployeDao;
import edu.dfs.evalJava.dao.UtilisateurDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UtilisateurController {
    private UtilisateurDao utilisateurDao;
    private EmployeDao employeDao;

    @Autowired
    public UtilisateurController(UtilisateurDao utilisateurDao, EmployeDao employeDao) {
        this.utilisateurDao = utilisateurDao;
        this.employeDao = employeDao;
    }

    @GetMapping("/compte-utilisateur")
    public int compteUtilisateur() {
        return utilisateurDao.compteUtilisateur();
    }

    @DeleteMapping("/utilisateur/{login}")
    public void supprimeUtilisateur(@PathVariable String login) {
        if(!employeDao.existsByLogin(login)){
            utilisateurDao.deleteByLogin(login);
        }
    }
}
