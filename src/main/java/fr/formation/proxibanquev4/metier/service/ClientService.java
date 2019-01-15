package fr.formation.proxibanquev4.metier.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import fr.formation.proxibanquev4.metier.entity.Client;
import fr.formation.proxibanquev4.persistance.ClientDao;

/**
 * Classe héritant de la classe abstraite RestService<ENTITY> Comporatant les
 * différents méthodes service qu'on utilise dans le viewController
 * 
 * @author JLSS
 *
 */
@Service
public class ClientService extends RestService<Client> {

	@Autowired
	private ClientDao clientDao;

	/**
	 * Méthodes permettant de retourner un objet clientDao.
	 */
	@Override
	protected JpaRepository<Client, Integer> getDao() {
		return this.clientDao;
	}

	/**
	 * Classe permettant de retourner la liste des clients de la base de données
	 * 
	 * @return
	 */
	public List<Client> getAll() {
		return this.clientDao.findAll();
	}
}
