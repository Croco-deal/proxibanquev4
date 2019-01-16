package fr.formation.proxibanquev4.metier.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Classe représentant toutes les informations d'un client Avec les annotations
 * JPA permettant de persister la classe en base de données
 * 
 * @author JLSS
 *
 */
@Entity
@Table(name = "client")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;

	@Column
	private String clientNumber;

	@Column
	private String firstname;

	@Column
	private String lastname;

	@Column
	private String mail;

	@Column
	private String tel;

	/**
	 * Constructeur vide.
	 */
	public Client() {
	}

	/**
	 * Constructeur utilisant les attributs.
	 * 
	 * @param id
	 * @param clientNumber
	 * @param firstname
	 * @param lastname
	 * @param mail
	 * @param tel
	 */
	public Client(Integer id, String clientNumber, String firstname, String lastname, String mail, String tel) {
		this.id = id;
		this.clientNumber = clientNumber;
		this.firstname = firstname;
		this.lastname = lastname;
		this.mail = mail;
		this.tel = tel;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClientNumber() {
		return clientNumber;
	}

	public void setClientNumber(String clientNumber) {
		this.clientNumber = clientNumber;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}
