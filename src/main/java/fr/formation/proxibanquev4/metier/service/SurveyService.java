package fr.formation.proxibanquev4.metier.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import fr.formation.proxibanquev4.metier.entity.Response;
import fr.formation.proxibanquev4.metier.entity.ResponseBySurvey;
import fr.formation.proxibanquev4.metier.entity.Survey;
import fr.formation.proxibanquev4.persistance.SurveyDao;

@Service
public class SurveyService extends RestService<Survey> {

	@Autowired
	private SurveyDao surveyDao;
	private List<ResponseBySurvey> responseBySurvey;

	@Override
	protected JpaRepository<Survey, Integer> getDao() {
		return this.surveyDao;
	}

	public Survey closeSurvey(Integer id) {
		Survey survey = this.surveyDao.getOne(id);
		survey.setEndDate(survey.getDate().now());
		this.surveyDao.save(survey);
		return survey;
	}

	public List<Survey> getAll() {
		return this.surveyDao.findAll();
	}

	public List<ResponseBySurvey> ShowAllResponsesBySurvey() {
		List<ResponseBySurvey> list = new ArrayList<>();		
		List<Survey> allSurvey = this.getAll();
		for (Survey survey : allSurvey) {
			ResponseBySurvey rbs = new ResponseBySurvey();
			rbs.setOpenDate(survey.getOpenDate());
			Integer surveyId = survey.getId();
			rbs.setIdSurvey(surveyId);
			Integer trueResponses = this.getTrueResponses(surveyId);
			Integer falseResponses = this.getFalseResponses(surveyId);
			rbs.setPositiveResp(trueResponses);
			rbs.setNegativeResp(falseResponses);
			list.add(rbs);
		}
		
		return list;
	}

	public Integer getTrueResponses(Integer id) {
		int i = 0;
		Survey survey = this.surveyDao.getOne(id);
		List<Response> responses = survey.getResponses();
		for (Response response : responses) {
			if (response.getIsTrue()) {
				i++;
				return i;
			} 
		}
		return i;
	}

	public Integer getFalseResponses(Integer id) {
		Survey survey = this.surveyDao.getOne(id);
		Integer falseResponses = survey.getResponses().size() - this.getTrueResponses(id);
		return falseResponses;
	}
}
