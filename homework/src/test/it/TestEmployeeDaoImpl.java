package test.it;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.personnel.components.*;
import com.personnel.dao.EmployeeDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "test-app-context.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestEmployeeDaoImpl {

	@Autowired
	private EmployeeDao dao;

	private static Employee employee, secondEmployee;
	private static SeminarType seminarType, secondSeminarType;
	private static Seminar seminar, secondSeminar;

	@Test
	public void testASaveEmployee() {
		employee = new Employee();
		employee.setEmployeeCode(1);
		employee.setFirstname("manousos");
		employee.setLastname("math");
		employee.setMiddlename("nothing");
		employee.setSalary(111111d);
		employee.setSex('M');

		dao.saveEmployee(employee);
	}

	@Test
	public void testASecodSaveEmployee() {
		secondEmployee = new Employee();
		secondEmployee.setEmployeeCode(1);
		secondEmployee.setFirstname("Soula");
		secondEmployee.setLastname("Agathoula");
		secondEmployee.setMiddlename("nothing");
		secondEmployee.setSalary(5423d);
		secondEmployee.setSex('F');

		dao.saveEmployee(secondEmployee);
	}

	@Test
	public void testBSaveSeminarType() {
		seminarType = new SeminarType();
		seminarType.setActive(Boolean.TRUE);
		seminarType.setName("type1");
		seminarType.setNotes("lol");
		seminarType.setSeminarTypeCode("S1");

		dao.saveSeminarType(seminarType);
	}

	@Test
	public void testBSaveSecondSeminarType() {
		secondSeminarType = new SeminarType();
		secondSeminarType.setActive(Boolean.TRUE);
		secondSeminarType.setName("type2");
		secondSeminarType.setNotes("όλα καλά");
		secondSeminarType.setSeminarTypeCode("S2");

		dao.saveSeminarType(secondSeminarType);
	}

	@Test
	public void testCSaveEmployeeSeminar() {
		seminar = new Seminar();
		seminar.setEmployee(employee);
		seminar.setSeminarType(seminarType);
		seminar.setSeminarDate(new Date());

		dao.saveEmployeeSeminar(seminar);
	}

	@Test
	public void testCSaveSecondEmployeeSeminar() {
		secondSeminar = new Seminar();
		secondSeminar.setEmployee(secondEmployee);
		secondSeminar.setSeminarType(secondSeminarType);
		secondSeminar.setSeminarDate(new Date());

		dao.saveEmployeeSeminar(secondSeminar);
	}

	@Test
	public void testGetEmployeeForId() {
		Employee result = dao.getEmployeeForId(employee.getEmployeeId());

		assertNotNull(result);
	}

	@Test
	public void testGetSeminarTypeForId() {
		SeminarType result = dao.getSeminarTypeForId(seminarType.getSeminarTypeId());

		assertNotNull(result);
	}

	@Test
	public void testGetAllEmployees() {
		List<Employee> results = dao.getAllEmployees();

		assertTrue(results.size() > 0);
	}

	@Test
	public void testGetAllSeminarTypes() {
		List<SeminarType> results = dao.getAllSeminarTypes();

		assertTrue(results.size() > 0);
	}

	@Test
	public void testGetEmployeeSeminars() {
		List<Seminar> results = dao.getEmployeeSeminars(employee.getEmployeeId());

		assertTrue(results.size() > 0);
	}

	@Test
	public void testGetSeminarForId() {
		assertNotNull(dao.getSeminarForId(seminar.getSeminarId()));
	}

	@Test
	public void testWDeleteEmployee() {
		dao.deleteEmployee(employee);
	}

	@Test
	public void testWDeleteSeminartype() {
		dao.deleteSeminartype(seminarType);
	}

	@Test
	public void testWDeleteEmployeeSeminar() {
		dao.deleteEmployeeSeminar(secondSeminar);
	}
}
