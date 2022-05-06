INSERT INTO moyen_paiement (nom) VALUES ("CB"),("Paypal");
INSERT INTO propriete (nom) VALUES ("Largeur"),("Hauteur"),("Poid");

INSERT INTO utilisateur (login,password)
VALUES ("cocolastico","5318008"),("kevinlehacker","azerty"),("admin","root"),("employe 1","qwerty");

INSERT INTO employe (id,administrateur)
VALUES (3,1),(4,0);

INSERT INTO article (nom, prix, gestionnaire_id)
VALUES ("GRÖNLID",19.0, 3),("HEMNES",34.0, 4),("EKTORP",32.0, 3),("LINANÄS",49.0, 4);

INSERT INTO caracteristique (article_id, propriete_id, valeur) VALUES (1,1,200),(1,2,300),(2,1,50);

INSERT INTO commande (date_paiement, client_id)
VALUES ("2022-01-02",3);

INSERT INTO ligne_commande (commande_id,article_id, quantite)
VALUES (1,1,5),(1,2,3);