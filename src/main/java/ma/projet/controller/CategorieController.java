package ma.projet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.projet.entities.Categorie;

@RestController
@RequestMapping("/api/categorie")
public class CategorieController {
	
	
	@Autowired
	private ma.projet.services.CategorieService service;

	@GetMapping
	public List<Categorie> findAllCategorie() {
		return service.findAll();
	}

	@PostMapping
	public Categorie createCategorie(@RequestBody Categorie o) {
		o.setId((long) 0);
		return service.create(o);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable int id) {
		Categorie o = service.findById(id);
		if (o == null) {
			return new ResponseEntity<Object>("Categorie avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			return ResponseEntity.ok(o);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateCategorie(@PathVariable int id, @RequestBody Categorie newCategorie) {
		Categorie oldCategorie = service.findById(id);
		if (oldCategorie == null) {
			return new ResponseEntity<Object>("Categorie avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			newCategorie.setId((long) id);
			return ResponseEntity.ok(service.update(newCategorie));
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCategorie(@PathVariable int id) {
		Categorie o = service.findById(id);
		if (o == null) {
			return new ResponseEntity<Object>("Categorie avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			service.delete(o);
			return ResponseEntity.ok("Filière supprimée");
		}
	}
}
