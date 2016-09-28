package com.personnel.services;

import java.util.List;

import com.personnel.components.Payroll;

public interface PayrollService {

	/**
	 * returns all Payroll records ordered by Year/Month descending order
	 * 
	 * @return
	 */
	public List<Payroll> getAllPayrolls();

	/**
	 * This method should be responsible to call a stored-procedure to delete all EmployeePayroll records related to the given payroll. This method will be
	 * useful making a batch calculation for all employees.
	 * 
	 * @param payroll
	 */
	public void deletePayrollRecords(Payroll payroll);

	/**
	 * This method should be responsible to create and calculate payroll records for all employees for the given payroll.
	 * 
	 * @param payroll
	 */
	public void calculatePayroll(Payroll payroll);

	public Payroll getPayrollForId(Integer payrollId);

	public void savePayroll(Payroll payroll);
}
