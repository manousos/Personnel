package com.personnel.ui;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.zkoss.bind.annotation.*;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.*;

import com.personnel.components.*;
import com.personnel.services.EmployeeService;

public class SeminarTypesVM extends AbstractVM {
	private static final String editPage = "/personnel/seminar-type-editor.zul";
	private ListModelList<SeminarType> seminarTypes;

	private Window seminarTypesEditor;
	@Autowired
	private EmployeeService service;

	@Init
	public void init() {
		onRefreshEmployee();
	}

	@Command("add-semType")
	public void onAddEmployee() {
		HashMap<String, Object> params = new HashMap<>();
		seminarTypesEditor = (Window) Executions.createComponents(editPage, null, params);
	}

	@Command("refresh-semType")
	public void onRefreshEmployee() {
		List<SeminarType> results = service.getAllSeminarTypes();
		if (results != null)
			seminarTypes = new ListModelList<>(results);
		else
			seminarTypes = new ListModelList<>();
	}

	@Command("edit-semType")
	public void onEditEmployee(@BindingParam("seminarType") SeminarType seminarType) {
		HashMap<String, Object> params = new HashMap<>();
		params.put("seminarType-Id", seminarType.getSeminarTypeId());
		seminarTypesEditor = (Window) Executions.createComponents(editPage, null, params);
	}

	@GlobalCommand("close-seminar-editor")
	public void onCallbackEmployeeEditor(@BindingParam("seminarType") SeminarType seminarType, @BindingParam("action") String action) {
		/*
		 * close the window
		 */
		seminarTypesEditor.detach();

		/*
		 * examine the action and update the data list model
		 */
		if ("SAVE".equals(action)) {
			int index = seminarTypes.indexOf(seminarType);
			if (index > -1)
				seminarTypes.set(index, seminarType);
			else
				seminarTypes.add(seminarType);
		} else if ("DELETE".equals(action)) {
			seminarTypes.remove(seminarType);
		}

	}

	public ListModelList<SeminarType> getSeminarTypes() {
		return seminarTypes;
	}



}
