package com.personnel.ui;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.zkoss.bind.annotation.*;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.*;

import com.personnel.components.*;
import com.personnel.services.EmployeeService;

public class EmployeeSeminarsVM extends AbstractVM {
	private static final String editPage = "/personnel/employee-seminar-editor.zul";

	private ListModelList<Seminar> employeeSeminars;

	public void setEmployeeSeminars(ListModelList<Seminar> employeeSeminars) {
		this.employeeSeminars = employeeSeminars;
	}

	private Integer employeeId;

	private Window employeeSeminarEditor;

	@Autowired
	private EmployeeService service;

	public ListModelList<Seminar> getEmployeeSeminars() {
		return employeeSeminars;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	@Init
	public void init() {
		employeeSeminars = new ListModelList<>();
	}

	@NotifyChange("employeeSeminars")
	@Command("find-seminars")
	public void onFindEmployeeSeminar() {
		List<Seminar> results = service.getEmployeeSeminars(employeeId);
		if (results != null) {
			employeeSeminars = new ListModelList<>(results);
		}
	}

	@Command("add-employeeSeminar")
	public void onAddSeminar() {
		HashMap<String, Object> params = new HashMap<>();
		employeeSeminarEditor = (Window) Executions.createComponents(editPage, null, params);
	}

	@Command("edit-employeeSeminar")
	public void onEditEmployeeSeminar(@BindingParam("seminar") Seminar seminar) {
		HashMap<String, Object> params = new HashMap<>();
		params.put("seminar-id", seminar.getSeminarId());
		employeeSeminarEditor = (Window) Executions.createComponents(editPage, null, params);
	}

	@GlobalCommand("close-seminar-editor")
	public void onCallbackEmployeeEditor(@BindingParam("seminar") Seminar seminar, @BindingParam("action") String action) {
		/*
		 * close the window
		 */
		employeeSeminarEditor.detach();

		/*
		 * examine the action and update the data list model
		 */
		if ("SAVE".equals(action)) {
			int index = employeeSeminars.indexOf(seminar);
			if (index > -1)
				employeeSeminars.set(index, seminar);
			else
				employeeSeminars.add(seminar);
		}
	}
}
