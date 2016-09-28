package com.personnel.components;

import java.util.Date;

public class Seminar {
	private Integer seminarId;
	private SeminarType seminarType;
	private Employee employee;
	private Date seminarDate;
	private String notes;

	public Integer getSeminarId() {
		return seminarId;
	}

	public void setSeminarId(Integer seminarId) {
		this.seminarId = seminarId;
	}

	public SeminarType getSeminarType() {
		return seminarType;
	}

	public void setSeminarType(SeminarType seminarType) {
		this.seminarType = seminarType;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Date getSeminarDate() {
		return seminarDate;
	}

	public void setSeminarDate(Date seminarDate) {
		this.seminarDate = seminarDate;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return seminarId + " " + seminarDate + " " + notes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((seminarId == null) ? 0 : seminarId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seminar other = (Seminar) obj;
		if (seminarId == null) {
			if (other.seminarId != null)
				return false;
		} else if (!seminarId.equals(other.seminarId))
			return false;
		return true;
	}

}
