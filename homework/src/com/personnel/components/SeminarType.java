package com.personnel.components;

import java.util.*;

public class SeminarType {

	/*
	 * surrogate key
	 */
	private Integer seminarTypeId;

	/*
	 * natural key
	 */
	private String seminarTypeCode;
	private String name;
	private String notes;
	private Boolean active;
	private Seminar seminar;
	Set<Seminar> seminars = new HashSet<Seminar>();

	public SeminarType() {
	}

	public Integer getSeminarTypeId() {
		return seminarTypeId;
	}

	public void setSeminarTypeId(Integer seminarTypeId) {
		this.seminarTypeId = seminarTypeId;
	}

	public String getSeminarTypeCode() {
		return seminarTypeCode;
	}

	public void setSeminarTypeCode(String seminarTypeCode) {
		this.seminarTypeCode = seminarTypeCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Seminar getSeminar() {
		return seminar;
	}

	public void setSeminar(Seminar seminar) {
		this.seminar = seminar;
	}

	public Set<Seminar> getSeminars() {
		return seminars;
	}

	public void setSeminars(Set<Seminar> seminars) {
		this.seminars = seminars;
	}

}