package com.personnel.components;

import java.util.*;

public class Employee {

	private Boolean active;
	private Integer employeeCode;
	private Integer employeeId;
	private String firstname;
	private String lastname;
	private String middlename;
	private String photo;
	private Character sex;
	private Double salary;
	private Set<Seminar> seminars = new HashSet<Seminar>();
	private Set<EmployeePayroll> employeePayrolls = new HashSet<EmployeePayroll>();

	public Employee() {
		active = Boolean.TRUE;
	}

	public Boolean getActive() {
		return active;
	}

	public Integer getEmployeeCode() {
		return employeeCode;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public Set<EmployeePayroll> getEmployeePayrolls() {
		return employeePayrolls;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public String getPhoto() {
		return photo;
	}

	public Set<Seminar> getSeminars() {
		return seminars;
	}

	public Character getSex() {
		return sex;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employeeCode == null) ? 0 : employeeCode.hashCode());
		return result;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public void setEmployeeCode(Integer employeeCode) {
		this.employeeCode = employeeCode;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public void setEmployeePayrolls(Set<EmployeePayroll> employeePayrolls) {
		this.employeePayrolls = employeePayrolls;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public void setSeminars(Set<Seminar> seminars) {
		this.seminars = seminars;
	}

	public void setSex(Character sex) {
		this.sex = sex;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return employeeCode + " " + lastname + " " + firstname;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (employeeCode == null) {
			if (other.employeeCode != null)
				return false;
		} else if (!employeeCode.equals(other.employeeCode))
			return false;
		return true;
	}
}
