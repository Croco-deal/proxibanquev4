package fr.formation.proxibanquev4.metier.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.proxibanquev4.metier.entity.Survey;
import fr.formation.proxibanquev4.persistance.SurveyDao;

public class SurveyService extends RestService<Survey>{

	@Autowired
	private SurveyDao surveyDao;
	private responseBySurvey List<ResponseBySurvey>;
	
	@Override
	protected JpaRepository<Survey, Integer> getDao() {
		return this.surveyDao;
	}
	
	public Survey closeSurvey(Integer id) {
		return null;
	}
	
	public List<ResponseBySurvey> showAllResponsesBySurvey(Integer id) {
		
		return null;
	}
}
