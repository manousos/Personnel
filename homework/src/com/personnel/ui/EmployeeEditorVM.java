package com.personnel.ui;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.*;

import com.personnel.components.Employee;
import com.personnel.services.EmployeeService;

public class EmployeeEditorVM extends AbstractVM {

	private Employee employee;
	@Autowired
	private EmployeeService service;

	@Init
	public void init(@ExecutionArgParam("employee-id") Integer employeeId) {

		/*
		 * if employee-id == null means that we want to create a new employee else we have to load the employee from the database before start editing
		 */
		if (employeeId == null)
			employee = new Employee();
		else {
			employee = service.getEmployeeForId(employeeId);
		}
	}

	@Command("save-employee")
	public void onSave() {
		service.saveEmployee(employee);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("employee", employee);
		params.put("action", "SAVE");
		BindUtils.postGlobalCommand(null, null, "close-employee-editor", params);
	}

	@Command("delete-employee")
	public void onDelete() {
		service.deleteEmployee(employee);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("employee", employee);
		params.put("action", "DELETE");
		BindUtils.postGlobalCommand(null, null, "close-employee-editor", params);
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
