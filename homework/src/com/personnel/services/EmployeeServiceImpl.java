package com.personnel.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.personnel.components.*;
import com.personnel.dao.EmployeeDao;

@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDao dao;

	public List<Employee> getAllEmployees() {

		return dao.getAllEmployees();
	}

	public Employee getEmployeeForId(Integer employeeId) {

		return dao.getEmployeeForId(employeeId);
	}

	@Transactional
	public void saveEmployee(Employee employee) {
		dao.saveEmployee(employee);
	}

	@Transactional
	public void deleteEmployee(Employee employee) {

		dao.deleteEmployee(employee);
	}

	/**
	 * returns a list of all available seminar types
	 * 
	 * @return
	 */
	public List<SeminarType> getAllSeminarTypes() {
		return dao.getAllSeminarTypes();
	}

	public SeminarType getSeminarTypeForId(Integer seminarTypeId) {
		return dao.getSeminarTypeForId(seminarTypeId);
	};

	/**
	 * insert/update a seminar type into the database
	 * 
	 * @param seminarType
	 */
	@Transactional
	public void saveSeminarType(SeminarType seminarType) {
		dao.saveSeminarType(seminarType);
	}

	/**
	 * remove a seminar type from the database
	 * 
	 * @param seminarType
	 */
	@Transactional
	public void deleteSeminartype(SeminarType seminarType) {
		dao.deleteSeminartype(seminarType);
	}

	/**
	 * returns a list of all Seminars attended by the given employee
	 * 
	 * @param employeeId
	 * @return
	 */
	
	public List<Seminar> getEmployeeSeminars(Integer employeeId) {
		return dao.getEmployeeSeminars(employeeId);
	}

	/**
	 * insert/update a seminar attendance into the database
	 * 
	 * @param seminar
	 */
	@Transactional
	public void saveEmployeeSeminar(Seminar seminar) {
		dao.saveEmployeeSeminar(seminar);
	}

	/**
	 * remove a seminar attendance from the database
	 * 
	 * @param seminar
	 */
	@Transactional
	public void deleteEmployeeSeminar(Seminar seminar) {
		dao.deleteEmployeeSeminar(seminar);
	}

	/**
	 * returns a list of SeminarTypes for which there is no related seminar record into the Seminars table for the given Employee. This method will be useful in
	 * case we want to find which seminar types have not been attended by the given employee.
	 * 
	 * @param employeeId
	 * @return
	 */
	public List<SeminarType> getSeminarTypesForEmployee(Integer employeeId) {
		List<SeminarType> employeeSeminarTypes = new ArrayList<SeminarType>();

		for (Seminar s : dao.getEmployeeSeminars(employeeId)) {
			s.getSeminarType().getSeminarTypeId();
			employeeSeminarTypes.add(s.getSeminarType());
		}
		List<SeminarType> allTypes = dao.getAllSeminarTypes();

		allTypes.removeAll(employeeSeminarTypes);

		return allTypes;
	}

	@Override
	public Seminar getSeminarForId(Integer seminarId) {
		return dao.getSeminarForId(seminarId);
	}
}
