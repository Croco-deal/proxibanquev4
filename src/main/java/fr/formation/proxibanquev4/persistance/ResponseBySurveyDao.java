package fr.formation.proxibanquev4.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.proxibanquev4.metier.entity.Client;

public interface ResponseBySurveyDao extends JpaRepository<Client, Integer>{

}
