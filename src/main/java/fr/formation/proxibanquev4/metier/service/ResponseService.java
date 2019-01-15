package fr.formation.proxibanquev4.metier.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import fr.formation.proxibanquev4.metier.entity.Response;
import fr.formation.proxibanquev4.persistance.ResponseDao;

@Service
public class ResponseService extends RestService<Response> {
	@Autowired
	private ResponseDao responseDao;
	
	@Override
	protected JpaRepository<Response, Integer> getDao() {
		return this.responseDao;
	}
//	
//	@PostMapping
//	public Article create(@RequestBody Article article) {
//		return this.service.create(article);
//	}
//	
}
