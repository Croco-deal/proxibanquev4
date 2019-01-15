package fr.formation.proxibanquev4.metier.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "survey")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "responses" })
public class Survey {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column
	private LocalDate openDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column
	private LocalDate endDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column
	private LocalDate closeDate;

	@OneToMany(mappedBy="survey")
	private List<Response> responses;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getOpenDate() {
		return openDate;
	}

	public void setOpenDate(LocalDate openDate) {
		this.openDate = openDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public LocalDate getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(LocalDate closeDate) {
		this.closeDate = closeDate;
	}

	public List<Response> getResponses() {
		return responses;
	}

	public void setResponses(List<Response> responses) {
		this.responses = responses;
	}

	public Survey(Integer id, LocalDate openDate, LocalDate endDate, LocalDate closeDate, List<Response> responses) {
		this.id = id;
		this.openDate = openDate;
		this.endDate = endDate;
		this.closeDate = closeDate;
		this.responses = responses;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Survey() {
		// TODO Auto-generated constructor stub
	}
}