package fr.formation.proxibanquev4.presentation;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.proxibanquev4.metier.entity.Survey;
import fr.formation.proxibanquev4.metier.service.ResponseService;
import fr.formation.proxibanquev4.metier.service.SurveyService;

	@Controller
	@RequestMapping("/")
	@Transactional(readOnly=true) 
	public class ViewController {

		private static final Logger LOGGER = Logger.getLogger(ViewController.class);
		
		private SurveyService surveyService;
		private ResponseService responseService;
	
	@RequestMapping({ "", "index" })
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index");
		String message = "Bienvenue sur votre espace sondage Proxibanquev4!";
		mav.addObject("message", message);
		LOGGER.info("Page Index-Sondage affichée!");
		return mav;
	}
	
	@RequestMapping("newSurvey")
	public ModelAndView showSurvey(Survey survey){
		ModelAndView mav = new ModelAndView();
		mav.addObject("openDate", survey.getOpenDate());
		mav.addObject("openDate", survey.getEndDate());
		return mav;
	}
}

