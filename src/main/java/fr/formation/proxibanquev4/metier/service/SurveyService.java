package fr.formation.proxibanquev4.metier.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.proxibanquev4.metier.entity.ResponseBySurvey;
import fr.formation.proxibanquev4.metier.entity.Survey;
import fr.formation.proxibanquev4.persistance.SurveyDao;

public class SurveyService extends RestService<Survey>{

	@Autowired
	private SurveyDao surveyDao;
	private List<ResponseBySurvey> responseBySurvey;
	
	@Override
	protected JpaRepository<Survey, Integer> getDao() {
		return this.surveyDao;
	}
	
	public Survey closeSurvey(Integer id) {
		return null;
	}
	
	public List<Survey> getAll() {
		return this.surveyDao.findAll();
	}
	
	public List<Survey> getAll(Integer id) {
		return this.surveyDao.findAll();
	}
}
