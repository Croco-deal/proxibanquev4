package fr.formation.proxibanquev4.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.proxibanquev4.metier.entity.Survey;

/**
 * Gestion de toutes les requêtes SQL la table 'survey'.
 * 
 * @author JLSS
 *
 */
@Repository
public interface SurveyDao extends JpaRepository<Survey, Integer>{
	
}

