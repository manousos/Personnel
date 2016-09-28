package com.personnel.services;

import java.util.List;

import com.personnel.components.*;

public interface EmployeeService {
	public List<Employee> getAllEmployees();

	public Employee getEmployeeForId(Integer employeeId);

	public SeminarType getSeminarTypeForId(Integer seminarTypeId);

	public void saveEmployee(Employee employee);

	public void deleteEmployee(Employee employee);

	public List<SeminarType> getAllSeminarTypes();

	public void saveSeminarType(SeminarType seminarType);

	public void deleteSeminartype(SeminarType seminarType);

	public List<Seminar> getEmployeeSeminars(Integer employeeId);

	public void saveEmployeeSeminar(Seminar seminar);

	public void deleteEmployeeSeminar(Seminar seminar);

	public List<SeminarType> getSeminarTypesForEmployee(Integer employeeId);

	public Seminar getSeminarForId(Integer seminarId);
}
