package com.personnel.dao;

import java.util.*;

import com.personnel.components.*;

public interface PayrollDao {
	public List<Payroll> getAllPayrolls();

	public void deleteEmployeePayroll(EmployeePayroll employeePayroll);

	void saveEmployeePayroll(EmployeePayroll employeePayroll);

	public Payroll getPayrollForId(Integer payrollId);

	public void savePayroll(Payroll payroll);

	Iterator<EmployeePayroll> getEmployeePayrollForPayroll(Payroll payroll);

	int deleteEmployeePayrollForIds(List<Integer> ids);
}
