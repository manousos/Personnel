package com.personnel.components;


public class EmployeePayroll {

	private Payroll payroll;
	private Employee employee;
	private Integer payableId;
	private Double salary;
	private Double tax;
	private Double netPayable;

	public Payroll getPayroll() {
		return payroll;
	}

	public void setPayroll(Payroll payroll) {
		this.payroll = payroll;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Integer getPayableId() {
		return payableId;
	}

	public void setPayableId(Integer payableId) {
		this.payableId = payableId;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	public Double getNetPayable() {
		return netPayable;
	}

	public void setNetPayable(Double netPayable) {
		this.netPayable = netPayable;
	}
}
