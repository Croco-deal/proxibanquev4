package fr.formation.proxibanquev4.presentation.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.proxibanquev4.metier.entity.Survey;
import fr.formation.proxibanquev4.metier.service.SurveyService;

@RestController
@RequestMapping("/survey")
@Transactional(readOnly=true)
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080"})
public class SurveyWebService {

	@Autowired
	private SurveyService surveyService;
	
	@GetMapping
	public Survey existingSurvey() {
		List<Survey> allSurvey = this.surveyService.getAll();
		Survey existingSurvey = null;
		for (Survey survey : allSurvey) {
			if (survey.getCloseDate() == null) {
				existingSurvey = survey;
			}
		}
		return existingSurvey;
	}
}
