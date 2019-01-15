package fr.formation.proxibanquev4.metier.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import fr.formation.proxibanquev4.metier.entity.Response;
import fr.formation.proxibanquev4.persistance.ResponseDao;

/**
 * Classe héritant de la classe abstraite 'RestService<ENTITY>' Comportant les
 * différentes méthodes service qu'on utilise dans le 'viewController'.
 * 
 * @author JLSS
 *
 */
@Service
public class ResponseService extends RestService<Response> {
	@Autowired
	private ResponseDao responseDao;

	/**
	 * Méthode permettant de retourner un objet reponseDao.
	 */
	@Override
	protected JpaRepository<Response, Integer> getDao() {
		return this.responseDao;
	}

}
