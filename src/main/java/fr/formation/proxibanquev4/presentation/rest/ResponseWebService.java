package fr.formation.proxibanquev4.presentation.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.proxibanquev4.metier.entity.Response;
import fr.formation.proxibanquev4.metier.service.ResponseService;

/**
 * Classe permettant de lier les réponses des sondages entre Java, Angular et la
 * base de données.
 * 
 * @author JLSS
 *
 */
@RestController
@RequestMapping("/response")
@Transactional(readOnly = true)
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080" })
public class ResponseWebService {

	@Autowired
	private ResponseService responseService;

	/**
	 * Méthode permettant de retourner la 'response' créée lors de la réponse à un
	 * sondage.
	 * 
	 * @param resp
	 */
	@PostMapping
	public Response create(@RequestBody Response resp) {
		return this.responseService.create(resp);
	}
}
