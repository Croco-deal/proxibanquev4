package fr.formation.proxibanquev4.metier.entity;

import java.time.LocalDate;

public class ResponseBySurvey {

	private Integer idSurvey;

	private Integer positiveResp;

	private Integer negativeResp;

	private LocalDate openDate;

	public ResponseBySurvey(Integer idSurvey, Integer positiveResp, Integer negativeResp, LocalDate openDate) {
		this.idSurvey = idSurvey;
		this.positiveResp = positiveResp;
		this.negativeResp = negativeResp;
		this.openDate = openDate;
	}

	public ResponseBySurvey() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdSurvey() {
		return idSurvey;
	}

	public void setIdSurvey(Integer idSurvey) {
		this.idSurvey = idSurvey;
	}

	public Integer getPositiveResp() {
		return positiveResp;
	}

	public void setPositiveResp(Integer positiveResp) {
		this.positiveResp = positiveResp;
	}

	public Integer getNegativeResp() {
		return negativeResp;
	}

	public void setNegativeResp(Integer negativeResp) {
		this.negativeResp = negativeResp;
	}

	public LocalDate getOpenDate() {
		return openDate;
	}

	public void setOpenDate(LocalDate openDate) {
		this.openDate = openDate;
	}
}
