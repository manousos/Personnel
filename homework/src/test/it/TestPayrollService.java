package test.it;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.personnel.components.Payroll;
import com.personnel.services.PayrollService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "test-app-context.xml" })
public class TestPayrollService {
	@Autowired
	PayrollService service;

	@Test
	public void testCalculatePayroll() {
		Payroll payroll= new Payroll();
		
		service.calculatePayroll(payroll);
	}
}
