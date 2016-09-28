package com.personnel.ui;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.*;

import com.personnel.components.*;
import com.personnel.services.PayrollService;

public class PayrollEditorVM extends AbstractVM {
	private Payroll payroll;
	@Autowired
	private PayrollService service;

	public Payroll getPayroll() {
		return payroll;
	}

	public void setPayroll(Payroll payroll) {
		this.payroll = payroll;
	}

	@Init
	public void init(@ExecutionArgParam("payroll-id") Integer payrollId) {		
		if (payrollId == null)
			payroll = new Payroll();
		else {
			payroll = service.getPayrollForId(payrollId);
		}
	}

	@Command("save-payroll")
	public void onSave() {
		service.savePayroll(payroll);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("payroll", payroll);
		params.put("action", "SAVE");
		BindUtils.postGlobalCommand(null, null, "close-payroll-editor", params);
	}
}
