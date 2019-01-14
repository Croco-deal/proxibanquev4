package fr.formation.proxibanquev4.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import fr.formation.proxibanquev4.metier.entity.Response;

@Repository
public interface ResponseDao extends JpaRepository<Response, Integer>{
}

