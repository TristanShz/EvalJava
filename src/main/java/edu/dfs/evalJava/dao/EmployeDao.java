package edu.dfs.evalJava.dao;

import edu.dfs.evalJava.model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeDao extends JpaRepository<Employe, Integer> {
    int countByAdministrateur(boolean b);
    boolean existsByLogin(String login);
}
