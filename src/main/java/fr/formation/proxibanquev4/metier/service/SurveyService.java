package fr.formation.proxibanquev4.metier.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import fr.formation.proxibanquev4.metier.entity.Response;
import fr.formation.proxibanquev4.metier.entity.ResponseBySurvey;
import fr.formation.proxibanquev4.metier.entity.Survey;
import fr.formation.proxibanquev4.persistance.SurveyDao;

/**
 * Classe héritant de la classe abstraite RestService<ENTITY>
 * Comporatant les différents méthodes service qu'on utilise  dans le viewController
 * @author JLSS
 *
 */
@Service
public class SurveyService extends RestService<Survey> {

	@Autowired
	private SurveyDao surveyDao;
    /**
     * Méthode permettant de retourner un objet surveyDao.
     */
	@Override
	protected JpaRepository<Survey, Integer> getDao() {
		return this.surveyDao;
	}
    /**
     * Méthode permettant de fermer un Survey en mettant la date de fermeture en date du jour
     * @param id identifiant du Survey
     * @return l'objet Survey mise à jour.
     */
	public Survey closeSurvey(Integer id) {
		Survey survey = this.surveyDao.getOne(id);
		survey.setCloseDate(LocalDate.now());
		this.surveyDao.save(survey);
		return survey;
	}
    /**
     * Méthode permettant de retourner tous les Survey enregistrés en base de données
     * @return une liste de Survey.
     */
	public List<Survey> getAll() {
		return this.surveyDao.findAll();
	}
	/**
	 * Méthode permettant de retourner un Survey de la base de données  en lui donnant le paramètre id du Survey
	 * @param id l'identifaint du Survey
	 * @return un objet Survey.
	 */
	public Survey getOne(Integer id) {
		Survey survey = this.surveyDao.getOne(id);
		return survey;
	}

      /**
       * Méthode permettant de retourner la liste de toutes les réponses  positives et négatives d'un survey
       * @return liste des réponses du survey
       */
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
	/**
	 * Méthode permattant de retourner le nombre réponses positives d'un survey
	 * @param id l'identifiant de survey dont on veut récupérer le nombre réponses positives
	 * @return le nombre de réponses positives du survey.
	 */

	public Integer getTrueResponses(Integer id) {
		int i = 0;
		Survey survey = this.surveyDao.getOne(id);
		List<Response> responses = survey.getResponses();
		for (Response response : responses) {
			if (response.getIsTrue()) {
				i++;
			}
		}
		return i;
	}
	/**
	 * Méthode permattant de retourner le nombre réponses négatives d'un survey
	 * @param id l'identifiant de survey dont on veut récupérer le nombre réponses négatives
	 * @return le nombre de réponses négatives du survey.
	 */

	public Integer getFalseResponses(Integer id) {
		Survey survey = this.surveyDao.getOne(id);
		Integer falseResponses = survey.getResponses().size() - this.getTrueResponses(id);
		return falseResponses;
	}
	/**
	 * Méthode permettant de vérifier l'existance d'un Survey en cours
	 * @return return un survey s'il y a un survey en cours et null s'il y a pas de survey en cours
	 */
	public Survey existingSurvey() {
		List<Survey> allSurvey = this.getAll();
		Survey existingSurvey = null;
		for (Survey survey : allSurvey) {
			if (survey.getCloseDate() == null) {
				existingSurvey = survey;
			}
		}
		return existingSurvey;
	}
	/**
	 * Méthode permettant de supprimer un Survey à partir de son identifiant
	 * @param id l'identifiant du Survey
	 */
	public void deleteSurvey(Integer id) {
		this.surveyDao.deleteById(id);
	}
}
