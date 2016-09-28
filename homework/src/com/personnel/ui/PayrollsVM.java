package com.personnel.ui;

import java.util.*;
import java.util.stream.*;

import javax.imageio.stream.IIOByteBuffer;

import org.springframework.beans.factory.annotation.Autowired;
import org.zkoss.bind.annotation.*;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.*;

import com.personnel.components.*;
import com.personnel.services.PayrollService;

public class PayrollsVM extends AbstractVM {
	private static final String editPage = "/personnel/payroll-editor.zul";

	private ListModelList<Payroll> payrolls;
	private Window payrollEditor;

	@Autowired
	private PayrollService service;

	public ListModelList<Payroll> getPayrolls() {
		return payrolls;
	}

	@Init
	public void init() {
		List<Payroll> results = service.getAllPayrolls();

		if (results != null) {
			payrolls = new ListModelList<>(results);
		} else {
			payrolls = new ListModelList<>();
		}
	}

	@Command("edit-payroll")
	public void onEditPayroll(@BindingParam("payroll") Payroll payroll) {
		HashMap<String, Object> params = new HashMap<>();
		params.put("payroll-id", payroll.getPayrollId());
		payrollEditor = (Window) Executions.createComponents(editPage, null, params);
	}

	@Command("add-payroll")
	public void onAddEmployee() {
		HashMap<String, Object> params = new HashMap<>();
		payrollEditor = (Window) Executions.createComponents(editPage, null, params);
	}

	@Command("calculate-payroll")
	public void onCalculatePayroll(@BindingParam("payroll") Payroll payroll) {
		service.calculatePayroll(payroll);
		Messagebox.show("Calculation completed");
	}

	@GlobalCommand("close-payroll-editor")
	public void onCallbackPayrollEditor(@BindingParam("payroll") Payroll payroll, @BindingParam("action") String action) {
		/*
		 * close the window
		 */
		payrollEditor.detach();

		/*
		 * examine the action and update the data list model
		 */
		if ("SAVE".equals(action)) {
			int index = payrolls.indexOf(payroll);
			if (index > -1)
				payrolls.set(index, payroll);
			else
				payrolls.add(payroll);
		}
	}
}
