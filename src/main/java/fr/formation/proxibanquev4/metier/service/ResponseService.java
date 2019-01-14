package fr.formation.proxibanquev4.metier.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.proxibanquev4.metier.entity.Response;
import fr.formation.proxibanquev4.persistance.ResponseDao;

public class ResponseService extends RestService<Response> {
	@Autowired
	private ResponseDao responseDao;
	
	@Override
	protected JpaRepository<Response, Integer> getDao() {
		return this.responseDao;
	}
	
	
}
