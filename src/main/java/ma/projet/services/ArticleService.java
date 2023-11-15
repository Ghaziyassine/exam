package ma.projet.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.projet.dao.IDao;
import ma.projet.entities.Article;
import ma.projet.entities.Categorie;
import ma.projet.repository.ArticleRepository;

@Service
public class ArticleService implements IDao<Article> {

	@Autowired
	private ArticleRepository repository;

	@Override
	public Article create(Article o) {
		return repository.save(o);
	}

	@Override
	public boolean delete(Article o) {
		try {
			repository.delete(o);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Article update(Article o) {
		return repository.save(o);
	}

	@Override
	public Article findById(int id) {
		return repository.findById((long) id).orElse(null);
	}

	@Override
	public List<Article> findAll() {
		return repository.findAll();
	}

	//public List<Article> findByDateProductionBetween(Date dateDebut, Date dateFin) {
	//	return repository.findByDateProductionBetween(dateDebut, dateFin);
	//}
	
	//public List<Article> findByDateProductionBetween(Date dateDebut, Date dateFin){
	//	return repository.findByDateProductionBetween(dateDebut, dateFin);
	//}


}