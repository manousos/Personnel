package com.personnel.dao;

import java.util.List;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.personnel.components.*;

@Repository
@Transactional(readOnly = true)
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<Employee> getAllEmployees() {
		Query query = getSession().createQuery("select E from Employee as E order by E.lastname");
		List<Employee> staff = (List<Employee>) query.list();

		return staff;
	}

	@Override
	public Employee getEmployeeForId(Integer employeeId) {
		Query query = getSession().createQuery("select E from Employee as E where E.employeeId = :EMPLOYEE_ID");
		query.setParameter("EMPLOYEE_ID", employeeId);
		Employee employee = (Employee) query.uniqueResult();

		return employee;
	}

	@Override
	@Transactional
	public void saveEmployee(Employee employee) {
		getSession().saveOrUpdate(employee);
	}

	@Override
	@Transactional
	public void deleteEmployee(Employee employee) {
		getSession().delete(employee);
	}

	@Override
	public List<SeminarType> getAllSeminarTypes() {
		Query q = getSession().createQuery("select st from SeminarType st");
		List<SeminarType> types = (List<SeminarType>) q.list();

		return types;
	}

	@Override
	@Transactional
	public void saveSeminarType(SeminarType seminarType) {
		getSession().saveOrUpdate(seminarType);
	}

	@Override
	@Transactional
	public void deleteSeminartype(SeminarType seminarType) {
		getSession().delete(seminarType);
	}

	@Override
	public List<Seminar> getEmployeeSeminars(Integer employeeId) {
		String queryString = "select e.seminars  from Employee e JOIN e.seminars where e.employeeId = :EMPLOYEE_ID";
		Query q = getSession().createQuery(queryString);
		q.setParameter("EMPLOYEE_ID", employeeId);
		List<Seminar> semianrs = (List<Seminar>) q.list();

		return semianrs;
	}

	@Override
	@Transactional
	public void saveEmployeeSeminar(Seminar seminar) {
		getSession().saveOrUpdate(seminar);
	}

	@Override
	@Transactional
	public void deleteEmployeeSeminar(Seminar seminar) {
		getSession().delete(seminar);
	}

	@Override
	public SeminarType getSeminarTypeForId(Integer seminarTypeId) {
		String queryStr = "select st from SeminarType st where st.seminarTypeId= :SEMINAR_TYPE_ID";
		Query q = getSession().createQuery(queryStr);
		q.setParameter("SEMINAR_TYPE_ID", seminarTypeId);

		SeminarType result = (SeminarType) q.uniqueResult();

		return result;
	}

	@Override
	public Seminar getSeminarForId(Integer seminarId) {
		String queryStr = "from Seminar s where s.seminarId= :SEMINAR_ID";
		Query q = getSession().createQuery(queryStr);
		q.setParameter("SEMINAR_ID", seminarId);

		Seminar result = (Seminar) q.uniqueResult();

		return result;
	}
}
