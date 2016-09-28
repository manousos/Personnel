package com.personnel.components;

import java.util.*;

public class Payroll {
	private Integer payrollId;
	private Integer year;
	private Integer month;
	private String description;
	private Set<EmployeePayroll> employeePayrolls = new HashSet<EmployeePayroll>();

	public Integer getPayrollId() {
		return payrollId;
	}

	public void setPayrollId(Integer payrollId) {
		this.payrollId = payrollId;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<EmployeePayroll> getEmployeePayrolls() {
		return employeePayrolls;
	}

	public void setEmployeePayrolls(Set<EmployeePayroll> employeePayrolls) {
		this.employeePayrolls = employeePayrolls;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((payrollId == null) ? 0 : payrollId.hashCode());
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
		Payroll other = (Payroll) obj;
		if (payrollId == null) {
			if (other.payrollId != null)
				return false;
		} else if (!payrollId.equals(other.payrollId))
			return false;
		return true;
	}

}
