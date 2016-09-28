package com.personnel.ui;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.*;

import com.personnel.components.*;
import com.personnel.services.EmployeeService;

public class SeminarTypesEditorVM extends AbstractVM {

	private SeminarType seminarType;
	@Autowired
	private EmployeeService service;

	@Init
	public void init(@ExecutionArgParam("seminarType-Id") Integer seminarTypeId) {

		/*
		 * if employee-id == null means that we want to create a new employee else we have to load the employee from the database before start editing
		 */
		if (seminarTypeId == null)
			seminarType = new SeminarType();
		else {
			seminarType = service.getSeminarTypeForId(seminarTypeId);
		}
	}

	@Command("save-smt")
	public void onSave() {
		service.saveSeminarType(seminarType);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("seminarType", seminarType);
		params.put("action", "SAVE");
		BindUtils.postGlobalCommand(null, null, "close-smt-editor", params);
	}

	@Command("delete-smt")
	public void onDelete() {
		service.deleteSeminartype(seminarType);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("seminarType", seminarType);
		params.put("action", "DELETE");
		BindUtils.postGlobalCommand(null, null, "close-smt-editor", params);
	}

	public SeminarType getSeminarType() {
		return seminarType;
	}

	public void setSeminarType(SeminarType seminarType) {
		this.seminarType = seminarType;
	}

}
