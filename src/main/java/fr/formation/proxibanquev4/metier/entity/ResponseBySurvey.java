package fr.formation.proxibanquev4.metier.entity;

import java.time.LocalDate;

public class ResponseBySurvey {
private Integer idSurvey;
private Integer positiveResp;
private Integer negativeReso;
private LocalDate openDate;

public ResponseBySurvey(Integer idSurvey, Integer positiveResp, Integer negativeReso, LocalDate openDate) {
	this.idSurvey = idSurvey;
	this.positiveResp = positiveResp;
	this.negativeReso = negativeReso;
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
public Integer getNegativeReso() {
	return negativeReso;
}
public void setNegativeReso(Integer negativeReso) {
	this.negativeReso = negativeReso;
}
public LocalDate getOpenDate() {
	return openDate;
}
public void setOpenDate(LocalDate openDate) {
	this.openDate = openDate;
}

}
