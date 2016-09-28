package com.personnel.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.personnel.components.*;
import com.personnel.dao.*;

@Service
@Transactional(readOnly = true)
public class PayrollServiceImpl implements PayrollService {
	@Autowired
	EmployeeDao employeeDao;
	@Autowired
	PayrollDao payrollDao;

	@Override
	public List<Payroll> getAllPayrolls() {
		return payrollDao.getAllPayrolls();
	}

	/**
	 * delete all EmployeePayroll records related to the given payroll
	 */
	@Transactional
	@Override
	public void deletePayrollRecords(Payroll payroll) {
		List<Integer> ids = new ArrayList<Integer>();
		Iterator<EmployeePayroll> empPayrolls = payrollDao.getEmployeePayrollForPayroll(payroll);

		for (; empPayrolls.hasNext();) {
			ids.add(empPayrolls.next().getPayableId());
		}
		payrollDao.deleteEmployeePayrollForIds(ids);
	}

	@Transactional
	@Override
	public void calculatePayroll(Payroll payroll) {
		deletePayrollRecords(payroll);

		List<Employee> employees = employeeDao.getAllEmployees();
		for (Employee e : employees) {
			EmployeePayroll employeePayroll = new EmployeePayroll();
			employeePayroll.setSalary(e.getSalary());
			employeePayroll.setTax(calculateTax(e.getSalary()));
			employeePayroll.setNetPayable(employeePayroll.getSalary() - employeePayroll.getTax());
			employeePayroll.setEmployee(e);
			employeePayroll.setPayroll(payroll);

			payrollDao.saveEmployeePayroll(employeePayroll);
		}
	}

	@Override
	public Payroll getPayrollForId(Integer payrollId) {
		Payroll payroll = payrollDao.getPayrollForId(payrollId);
		return payroll;
	}

	@Transactional
	@Override
	public void savePayroll(Payroll payroll) {
		payrollDao.savePayroll(payroll);
	}

	Double calculateTax(Double salary) {
		Double tax = 0d;

		if (salary < 0) {
			return tax;
		}

		if (salary <= 2000) {
			tax = salary * 0.02;
		} else if (salary >= 20001 && salary <= 4000) {
			tax = salary * 0.04;
		} else {
			tax = salary * 0.06;
		}

		return tax;
	}
}
