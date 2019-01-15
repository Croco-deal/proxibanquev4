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

@RestController
@RequestMapping("/response")
@Transactional(readOnly=true)
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080"})
public class ResponseWebService {

	@Autowired
	private ResponseService responseService;
	
	 @PostMapping
	    public Response create(@RequestBody Response resp) {
	        return this.responseService.create(resp);
	    }
}
