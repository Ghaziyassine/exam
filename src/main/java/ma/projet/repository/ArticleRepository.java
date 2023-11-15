package ma.projet.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.projet.entities.Article;
import ma.projet.entities.Categorie;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

	//public List<Article> findByDateProductionBetween(Date dateDebut, Date dateFin);

//	public List<Article> findByDateProductionBetween(Date dateDebut, Date dateFin);
}
