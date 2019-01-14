package fr.formation.proxibanquev4.metier.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="response")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Response {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer id;
	@Column
	private Boolean isTrue;
	@Column
	private String comment;
	@OneToOne
	@JoinColumn(name="client_id", referencedColumnName="id")
	private Client client;
	@OneToOne
	@JoinColumn(name="survey_id", referencedColumnName="id")
	private Survey survey;
	
	public Response() {
	}
	public Response(Integer id, Boolean isTrue, String comment, Client client, Survey survey) {
		this.id = id;
		this.isTrue = isTrue;
		this.comment = comment;
		this.client = client;
		this.survey = survey;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Boolean getIsTrue() {
		return isTrue;
	}
	public void setIsTrue(Boolean isTrue) {
		this.isTrue = isTrue;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Survey getSurvey() {
		return survey;
	}
	public void setSurvey(Survey survey) {
		this.survey = survey;
	}
	
	
	
}
