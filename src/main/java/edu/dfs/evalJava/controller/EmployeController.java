package edu.dfs.evalJava.controller;

import com.fasterxml.jackson.annotation.JsonView;
import edu.dfs.evalJava.dao.EmployeDao;
import edu.dfs.evalJava.model.Employe;
import edu.dfs.evalJava.views.AffichageEmploye;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class EmployeController {

    private EmployeDao employeDao;

    @Autowired
    public EmployeController(EmployeDao employeDao) {
        this.employeDao = employeDao;
    }

    @GetMapping("/employe/{id}")
    @JsonView(AffichageEmploye.class)
    public Employe employe(@PathVariable Integer id){
        return employeDao.findById(id).orElse(null);
    }

    @GetMapping("/liste-employe")
    @JsonView(AffichageEmploye.class)
    public List<Employe> listEmploye() {
        return employeDao.findAll();
    }

    @GetMapping("/compte-administrateur")
    public int compteAdministrateur(){
        return employeDao.countByAdministrateur(true);
    }
}
