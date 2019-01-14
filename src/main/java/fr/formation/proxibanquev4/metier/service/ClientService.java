package fr.formation.proxibanquev4.metier.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import fr.formation.proxibanquev4.metier.entity.Client;
import fr.formation.proxibanquev4.persistance.ClientDao;

@Service
public class ClientService extends RestService<Client> {

	@Autowired
	private ClientDao clientDao;
	
	@Override
	protected JpaRepository<Client, Integer> getDao() {
		return this.clientDao;
	}
	
}
