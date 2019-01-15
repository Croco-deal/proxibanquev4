package fr.formation.proxibanquev4.presentation.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.proxibanquev4.metier.entity.Client;
import fr.formation.proxibanquev4.metier.service.ClientService;

/**
 * Classe permettant de lier les clients entre Java, Angular et la base de
 * données.
 * 
 * @author JLSS
 *
 */
@RestController
@RequestMapping("/client")
@Transactional(readOnly = true)
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080" })
public class ClientWebService {

	@Autowired
	private ClientService clientService;

	/**
	 * Méthode permettant de retourner un 'client' si ce dernier possède bien un
	 * 'number'.
	 * 
	 * @param number : numéro d'identification du client (String).
	 * @return Client.
	 */
	@GetMapping("/{number}")
	public Client existingClient(@PathVariable String number) {
		Client existingClient = null;
		List<Client> clients = this.clientService.getAll();
		for (Client client : clients) {
			if (number.equals(client.getClientNumber())) {
				existingClient = client;
				break;
			}
		}
		return existingClient;
	}
}
