package edu.dfs.evalJava.controller;


import edu.dfs.evalJava.dao.ArticleDao;
import edu.dfs.evalJava.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ArticleController {

    private ArticleDao articleDao;

    @Autowired
    public ArticleController(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @PostMapping("/article")
    public void ajouterArticle(@RequestBody Article articleSelectionner) {
        articleDao.save(articleSelectionner);
    }
}
