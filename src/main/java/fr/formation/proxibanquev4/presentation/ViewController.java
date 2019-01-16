package fr.formation.proxibanquev4.presentation;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.proxibanquev4.RedirectConstant;
import fr.formation.proxibanquev4.metier.entity.ResponseBySurvey;
import fr.formation.proxibanquev4.metier.entity.Survey;
import fr.formation.proxibanquev4.metier.service.ResponseService;
import fr.formation.proxibanquev4.metier.service.SurveyService;

	@Controller
	@RequestMapping("/")
	@Transactional(readOnly=true) 
	public class ViewController {

		private static final Logger LOGGER = Logger.getLogger(ViewController.class);
		@Autowired
		private SurveyService surveyService;
	
	@RequestMapping({ "", "index" })
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index");
		Survey surveyExists = this.surveyService.existingSurvey();
		if (surveyExists != null) {
			mav.addObject("surveyExists",surveyExists);
			LOGGER.info("Page Index-Sondage affichée!");
			mav.addObject("openDate", surveyExists.getOpenDate());
			mav.addObject("endDate", surveyExists.getEndDate());
			mav.addObject("idSurvey", surveyExists.getId());
		} 
		return mav;
	}
	
	@RequestMapping("newSurvey")
	public ModelAndView showSurvey(){
		ModelAndView mav = new ModelAndView("newSurvey");
		Survey survey = new Survey();
		mav.addObject("openDate", survey.getOpenDate());
		mav.addObject("endDate", survey.getEndDate());
		return mav;
	}
	
	@RequestMapping(path="newSurvey", method=RequestMethod.POST)
	public String createSurvey(Survey survey) {
		this.surveyService.create(survey);
		return RedirectConstant.REDIRECT_TO_INDEX;
	}
	
	@RequestMapping("viewSurveys")
	public ModelAndView showAllResponsesBySurvey() {
		ModelAndView mav = new ModelAndView();
		List<Survey> allSurvey = this.surveyService.getAll();
		List<ResponseBySurvey> rbs =  this.surveyService.ShowAllResponsesBySurvey();
		mav.addObject("allSurvey", allSurvey);
		mav.addObject("rbs", rbs);
		return mav;
	}
	
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
	
	@RequestMapping("delete")
	public String deleteSurvey(Integer id) {
		LOGGER.debug("Action suppression d'un sondage!");
		this.surveyService.delete(id);
		return RedirectConstant.REDIRECT_TO_VIEW_SURVEYS;
	}
}
