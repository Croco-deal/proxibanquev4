package fr.formation.proxibanquev4;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 * Classe héritant de 'ObjectMapper'
 * 
 * @author JLSS
 *
 */
public class JavaTimeObjectMapper extends ObjectMapper {

	private static final long serialVersionUID = 1L;

	/**
	 * Enregistrement du module de conversion de LocalDate (API Java Time == JSR310)
	 * pour Jackson.
	 */
	public JavaTimeObjectMapper() {
		registerModule(new JavaTimeModule());
	}
}