package com.personnel.dao;

import java.util.List;

import com.personnel.components.*;

public interface EmployeeDao {
	public List<Employee> getAllEmployees();

	public Employee getEmployeeForId(Integer employeeId);

	public void saveEmployee(Employee employee);

	public void deleteEmployee(Employee employee);

	/**
	 * returns a list of all available seminar types
	 * 
	 * @return
	 */
	public List<SeminarType> getAllSeminarTypes();

	/**
	 * insert/update a seminar type into the database
	 * 
	 * @param seminarType
	 */
	public void saveSeminarType(SeminarType seminarType);

	/**
	 * remove a seminar type from the database
	 * 
	 * @param seminarType
	 */
	public void deleteSeminartype(SeminarType seminarType);

	/**
	 * returns a list of all Seminars attended by the given employee
	 * 
	 * @param employeeId
	 * @return
	 */
	public List<Seminar> getEmployeeSeminars(Integer employeeId);

	/**
	 * insert/update a seminar attendance into the database
	 * 
	 * @param seminar
	 */
	public void saveEmployeeSeminar(Seminar seminar);

	/**
	 * remove a seminar attendance from the database
	 * 
	 * @param seminar
	 */
	public void deleteEmployeeSeminar(Seminar seminar);

	public SeminarType getSeminarTypeForId(Integer seminarTypeId);

	public Seminar getSeminarForId(Integer seminarId);

	/**
	 * returns a list of SeminarTypes for which there is no related seminar record into the Seminars table for the given Employee. This method will be useful in
	 * case we want to find which seminar types have not been attended by the given employee.
	 * 
	 * @param employeeId
	 * @return
	 */
	//public List<SeminarType> getSeminarTypesForEmployee(Integer employeeId);
}
