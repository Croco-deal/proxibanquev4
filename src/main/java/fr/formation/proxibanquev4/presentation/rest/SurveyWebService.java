package fr.formation.proxibanquev4.presentation.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.proxibanquev4.metier.entity.Survey;
import fr.formation.proxibanquev4.metier.service.SurveyService;

/**
 * Classe permettant de lier les sondages entre Java, Angualar et la base de donnéess.
 * 
 * @author JLSS
 *
 */
@RestController
@RequestMapping("/survey")
@Transactional(readOnly=true)
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080"})
public class SurveyWebService {

	@Autowired
	private SurveyService surveyService;
	
	/**
	 * Méthode permettant de retourner l'existance d'un sondage.
	 */
	@GetMapping
	public Survey existingSurvey() {
		return this.surveyService.existingSurvey();
	}
}
