package fr.formation.proxibanquev4.presentation.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.proxibanquev4.metier.entity.Client;
import fr.formation.proxibanquev4.metier.service.ClientService;

@RestController
@RequestMapping("/client")
@Transactional(readOnly=true)
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080"})
public class ClientWebService {

	@Autowired
	private ClientService clientService;
	
	@PostMapping
	public Client existingClient(@RequestBody Client client) {
		Client existingClient = null;
		String numberClient = client.getClientNumber();
		List<Client> clients = this.clientService.getAll();
			for (Client isclient: clients) {
				if (numberClient == isclient.getClientNumber()) {
					existingClient = client;
				}
			}
		return existingClient;
	}
}
