package fr.formation.proxibanquev4.presentation.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.proxibanquev4.metier.entity.Client;
import fr.formation.proxibanquev4.metier.entity.Response;
import fr.formation.proxibanquev4.metier.service.ClientService;

/**
 * Classe permettant de lier les données relatives au client entre l'application JEE et l'application Angular.
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
	 * numéro de client (attribut clientNumber).
	 * 
	 * @param clientNumber : numéro d'identification du client (String).
	 * @return objet de type Client.
	 */
	@GetMapping("/{clientNumber}")
	public Client existingClient(@PathVariable String clientNumber) {
		Client existingClient = null;
		List<Client> clients = this.clientService.getAll();
		for (Client client : clients) {
			if (clientNumber.equals(client.getClientNumber())) {
				existingClient = client;
				break;
			}
		}
		return existingClient;
	}
	
	/**
	 * Méthode permettant de récupérer l'objet client de type Client, contenant
	 * les informations du nouveau client créé sur l'application Angular 
	 * 
	 * @param client 
	 */
	@PostMapping
	public Client create(@RequestBody Client client) {
		return this.clientService.create(client);
	}
}
