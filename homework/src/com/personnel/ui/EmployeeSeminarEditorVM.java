package com.personnel.ui;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.*;

import com.personnel.components.*;
import com.personnel.services.EmployeeService;

public class EmployeeSeminarEditorVM extends AbstractVM {
	private Seminar seminar;
	@Autowired
	private EmployeeService service;

	public Seminar getSeminar() {
		return seminar;
	}

	public void setSeminar(Seminar seminar) {
		this.seminar = seminar;
	}

	@Init
	public void init(@ExecutionArgParam("seminar-id") Integer seminarId) {
		if (seminarId == null)
			seminar = new Seminar();
		else {
			seminar = service.getSeminarForId(seminarId);
		}
	}

	@Command("save-employeeSeminar")
	public void onSave() {
		service.saveEmployeeSeminar(seminar);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("seminar", seminar);
		params.put("action", "SAVE");
		BindUtils.postGlobalCommand(null, null, "close-employeeSeminar-editor", params);
	}

}
