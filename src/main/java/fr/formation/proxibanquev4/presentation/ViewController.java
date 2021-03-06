package fr.formation.proxibanquev4.presentation;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.proxibanquev4.RedirectConstant;
import fr.formation.proxibanquev4.metier.entity.ResponseBySurvey;
import fr.formation.proxibanquev4.metier.entity.Survey;
import fr.formation.proxibanquev4.metier.service.SurveyService;

/**
 * Controleur des vues responsable de distribuer les bons objets vues/model pour
 * aller vers une page JSP avec les informations dans le model.
 * 
 * L'annotation @Controller défini la classe en tant que bean Spring singleton.
 * L'annotation @RequestMapping défini la classe comme capable de répondre sur
 * les requêtes HTTP commençant par "/".
 * 
 * @author JLSS
 * 
 */

@Controller
@RequestMapping("/")
@Transactional(readOnly = true)
public class ViewController {

	/**
	 * Déclaration du Logger pour cette classe.
	 */
	private static final Logger LOGGER = Logger.getLogger(ViewController.class);

	/**
	 * Injection d'une dépendance au service des sondages.
	 */
	@Autowired
	private SurveyService surveyService;

	/**
	 * Répond sur "http://localhost:8080/proxibanquev4/" et
	 * "http://localhost:8080/proxibanquev4/index.html". Permet de préparer la page
	 * index avec le sondage existant, sa date d'ouverture, sa date de fermeture
	 * prévisonnelle et son id.
	 * 
	 * @return ModelAndView la vue index.
	 */
	@RequestMapping({ "", "index" })
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index");
		Survey surveyExists = this.surveyService.existingSurvey();
		if (surveyExists != null) {
			mav.addObject("surveyExists", surveyExists);
			LOGGER.info("Page Index-Sondage affichée!");
			mav.addObject("openDate", surveyExists.getOpenDate());
			mav.addObject("endDate", surveyExists.getEndDate());
			mav.addObject("idSurvey", surveyExists.getId());
		}
		return mav;
	}

	/**
	 * Répond sur "http://localhost:8080/proxibanquev4/newSurvey.html". Prépare le
	 * formulaire avec les deux champs qui seront remplis par l'utilisateur, soit la
	 * date d'ouverture du sondage et sa date de fin prévisionnelle.
	 * 
	 * @return ModelAndView la page contenant le formulaire de création du sondage.
	 */
	@RequestMapping("newSurvey")
	public ModelAndView showSurvey() {
		ModelAndView mav = new ModelAndView("newSurvey");
		Survey survey = new Survey();
		mav.addObject("openDate", survey.getOpenDate());
		mav.addObject("endDate", survey.getEndDate());
		return mav;
	}

	/**
	 * Répond sur le "Valider" du formulaire sur
	 * "http://localhost:8080/proxibanquev4/newSurvey.html". Permet de créer un
	 * nouveau sondage.
	 * 
	 * @param survey un objet Survey avec une date d'ouverture et une date de fin
	 *               prévisionnelle, envoyés dans le corps de la requête.
	 * @return String la chaine de redirection vers index.
	 */
	@RequestMapping(path = "newSurvey", method = RequestMethod.POST)
	public String createSurvey(Survey survey) {
		this.surveyService.create(survey);
		return RedirectConstant.REDIRECT_TO_INDEX;
	}

	/**
	 * Répond sur "http://localhost:8080/proxibanquev4/viewSurveys.html". Prépare la
	 * liste des sondages et de leurs réponses (négatives et positives).
	 * 
	 * @return ModelAndView la page contenant la liste des sondages et de leurs
	 *         réponses .
	 */
	@RequestMapping("viewSurveys")
	public ModelAndView showAllResponsesBySurvey() {
		ModelAndView mav = new ModelAndView();
		List<Survey> allSurvey = this.surveyService.getAll();
		List<ResponseBySurvey> rbs = this.surveyService.ShowAllResponsesBySurvey();
		mav.addObject("allSurvey", allSurvey);
		mav.addObject("rbs", rbs);
		return mav;
	}

	/**
	 * Répond sur "http://localhost:8080/proxibanquev4/closeSurvey.html". Permet de
	 * clôturer un sondage en cours en y ajoutant une date de fermeture.
	 * 
	 * @param id l'identifiant du sondage à clôturer.
	 * @return ModelAndView la page contenant l'id du sondage supprimé.
	 */
	@RequestMapping("closeSurvey")
	public ModelAndView closeSurvey(Integer id) {
		ModelAndView mav = new ModelAndView("closeSurvey");
		Survey surveyExists = this.surveyService.existingSurvey();
		this.surveyService.closeSurvey(id);
		mav.addObject("surveyExists", surveyExists);
		mav.addObject("idSurvey", surveyExists.getId());
		LOGGER.info("Sondage clôturé");
		return mav;
	}

	/**
	 * Répond sur "http://localhost:8080/proxibanquev4/delete.html?id=". Permet de
	 * supprimer un sondage.
	 * 
	 * @param id l'identifiant du sondage à supprimer.
	 * @return String la chaine de redirection vers le début du sondage.
	 */
	@RequestMapping("delete")
	public String deleteSurvey(Integer id) {
		LOGGER.debug("Action suppression d'un sondage!");
		this.surveyService.delete(id);
		return RedirectConstant.REDIRECT_TO_VIEW_SURVEYS;
	}
}
