package com.personnel.ui;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.zkoss.bind.annotation.*;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.*;

import com.personnel.components.Employee;
import com.personnel.services.EmployeeService;

public class EmployeesVM extends AbstractVM {
	private static final String editPage = "/personnel/seminar-type-editor.zul";

	private ListModelList<Employee> staff;

	private Window employeeEditor;
	@Autowired
	private EmployeeService service;

	@Init
	public void init() {
		onRefreshEmployee();
	}

	@Command("add-employee")
	public void onAddEmployee() {
		HashMap<String, Object> params = new HashMap<>();
		employeeEditor = (Window) Executions.createComponents(editPage, null, params);
	}

	@Command("refresh-employee")
	public void onRefreshEmployee() {
		List<Employee> results = service.getAllEmployees();
		if (results != null)
			staff = new ListModelList<>(results);
		else
			staff = new ListModelList<>();
	}

	@Command("edit-employee")
	public void onEditEmployee(@BindingParam("employee") Employee employee) {
		HashMap<String, Object> params = new HashMap<>();
		params.put("employee-id", employee.getEmployeeId());
		employeeEditor = (Window) Executions.createComponents(editPage, null, params);
	}

	@GlobalCommand("close-employee-editor")
	public void onCallbackEmployeeEditor(@BindingParam("employee") Employee employee, @BindingParam("action") String action) {
		/*
		 * close the window
		 */
		employeeEditor.detach();

		/*
		 * examine the action and update the data list model
		 */
		if ("SAVE".equals(action)) {
			int index = staff.indexOf(employee);
			if (index > -1)
				staff.set(index, employee);
			else
				staff.add(employee);
		} else if ("DELETE".equals(action)) {
			staff.remove(employee);
		}

	}

	public ListModel<Employee> getStaff() {
		return staff;
	}

}
