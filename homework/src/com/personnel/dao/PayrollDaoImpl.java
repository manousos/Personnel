package com.personnel.dao;

import java.util.*;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.personnel.components.*;

@Repository
@Transactional(readOnly = true)
public class PayrollDaoImpl implements PayrollDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * returns all Payroll records ordered by Year/Month descending order
	 */
	@Override
	public List<Payroll> getAllPayrolls() {
		Query q = getSession().createQuery("from Payroll p Order BY p.year DESC, p.month DESC");
		List<Payroll> payrolls = (List<Payroll>) q.list();

		return payrolls;
	}

	@Override
	public Payroll getPayrollForId(Integer payrollId) {
		Query q = getSession().createQuery("from Payroll p WHERE p.payrollId =:PAYROLL_ID");
		q.setParameter("PAYROLL_ID", payrollId);
		Payroll p = (Payroll) q.uniqueResult();

		return p;
	}

	@Transactional
	@Override
	public int deleteEmployeePayrollForIds(List<Integer> ids) {
		Query q = getSession().createQuery("Delete from EmployeePayroll ep WHERE ep.payableId in :PK_IDS");
		q.setParameterList("PK_IDS", ids);

		return q.executeUpdate();
	}

	@Override
	public Iterator<EmployeePayroll> getEmployeePayrollForPayroll(Payroll payroll) {
		Query q = getSession().createQuery("from EmployeePayroll ep WHERE ep.payroll =:PAYROLL");
		q.setParameter("PAYROLL", payroll);
		Iterator<EmployeePayroll> resuts = (Iterator<EmployeePayroll>) q.iterate();

		return resuts;
	}

	@Transactional
	@Override
	public void deleteEmployeePayroll(EmployeePayroll employeePayroll) {
		getSession().delete(employeePayroll);
	}

	@Transactional
	@Override
	public void saveEmployeePayroll(EmployeePayroll employeePayroll) {
		getSession().saveOrUpdate(employeePayroll);
	}

	@Transactional
	@Override
	public void savePayroll(Payroll payroll) {
		getSession().saveOrUpdate(payroll);
	}

}
