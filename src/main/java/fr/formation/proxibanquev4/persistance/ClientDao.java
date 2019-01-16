package fr.formation.proxibanquev4.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.proxibanquev4.metier.entity.Client;

/**
 * Gestion de toutes les requêtes SQL la table 'client'.
 * 
 * @author JLSS
 *
 */
@Repository
public interface ClientDao extends JpaRepository<Client, Integer> {
}
