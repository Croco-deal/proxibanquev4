package fr.formation.proxibanquev4.metier.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Définition commune pour les services utilisés par les services web REST.
 * 
 * @author Jessica, Laïla, Sarah, Sidney
 *
 * @param <ENTITY>
 *            l'entité utilisée par le DAO.
 */
public abstract class RestService<ENTITY> {

	/**
	 * @return JpaRepository<ENTITY, Integer> le DAO a utiliser pour effectuer
	 *         l'accès BDD.
	 */
	protected abstract JpaRepository<ENTITY, Integer> getDao();
	/**
	 * Méthode permettant de créer une entity
	 * @param entity
	 * @return l'entity crée
	 */
	public ENTITY create(final ENTITY entity) {
		return this.getDao().save(entity);
	}
	/**
	 * Méthode permettant de récupérer une entity à partir de son identifiant
	 * @param id l'identifiant de l'entity
	 * @return retourn l'entity de la base de donnée
	 */
	public ENTITY read(final Integer id) {
		return this.getDao().getOne(id);
	}
	/**
	 * Méthode permettant de récupérer toutes les entitiés 
	 * @return la liste des entities
	 */
	
	public List<ENTITY> readAll() {
		return this.getDao().findAll();
	}
	/**
	 * Méthode permettant de mettre à jour une entity
	 * @param l'entity qu'on veut mettre à jour
	 * @return l'entity mise à jour
	 */
	public ENTITY update(final ENTITY entity) {
		return this.getDao().save(entity);
	}
	/**
	 * Méthode permettant de supprimer l'entity à partir de l'id
	 * @param id l'identifiant de l'entity qu'on veut supprimer
	 */
	public void delete(final Integer id) {
		this.getDao().deleteById(id);
	}
}
