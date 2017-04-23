/**
 * 
 */
package oscar.assignment1.junit4.employee.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import static org.junit.Assert.assertEquals;
import junit.framework.JUnit4TestAdapter;
import junit.textui.TestRunner;
import org.junit.Test;

/**
 * @author Oscar Arreola
 *
 * Implements test methods:
 * 
 * 	testMin:
 * 		Tests the return value of the EmployeeApp.minimumSalaray() method.
 * 
 * 	testMax:
 * 		Tests the return value of the EmployeeApp.maximumSalaray() method.
 * 
 * 	testAverage:
 * 		Tests the return value of the EmployeeApp.averageSalaray() method.
 * 
 * 	testDivideByZeroException:
 * 		Tests that the EmployeeApp.averageSalaray() method throws an
 * 		ArithmeticException on a divide-by-zero condition.
 * 
 * 	testIndexException:
 * 		Tests that the EmployeeApp.populateEmployeeArray() method throws
 * 		an ArrayIndexOutOfBoundsException when attempting to add a
 * 		6th Employee object.
 * 
 */
public class EmployeeTestCase {
	EmployeeApp employeeApp;
	Employee [] employeeArray;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.employeeApp = new EmployeeApp(5);
		this.employeeApp.populateEmployeeArray(
				employeeApp.populateEmployee(6198001, "Peter",  500000));
		this.employeeApp.populateEmployeeArray(
				employeeApp.populateEmployee(6198002, "Jane",    95000));
		this.employeeApp.populateEmployeeArray(
				employeeApp.populateEmployee(6198003, "Jim",     850000));
		this.employeeApp.populateEmployeeArray(
				employeeApp.populateEmployee(6198004, "Albert", 150000));
		this.employeeApp.populateEmployeeArray(
				employeeApp.populateEmployee(6198005, "Thomas", 200000));
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		this.employeeApp = null;
	}

	@Test
	public void testMin() {
		double min = 0;

		for (int i=0; i < employeeApp.numberOfEmployees; i++) {
			if (i == 0)
				min = employeeApp.employeeArray[i].getSalary();
			if (employeeApp.employeeArray[i].getSalary() < min)
				min = employeeApp.employeeArray[i].getSalary();
		}
		assertEquals(min, employeeApp.minimumSalaray(), 0);
	}
	
	@Test
	public void testMax() {
		double max = 0;

		for (int i=0; i < employeeApp.numberOfEmployees; i++) {
			if (i == 0)
				max = employeeApp.employeeArray[i].getSalary();
			if (employeeApp.employeeArray[i].getSalary() > max)
				max = employeeApp.employeeArray[i].getSalary();
		}
		assertEquals(max, employeeApp.maximumSalaray(), 0);
	}
	
	@Test
	public void testAverage() {
		double total = 0;
		double average = 0;

		for (int i = 0; i < employeeApp.numberOfEmployees; i++) {
			total = total + employeeApp.employeeArray[i].getSalary();
		}
		average = total / employeeApp.numberOfEmployees;
		assertEquals(average, employeeApp.averageSalary(), 0);
	}

	@Test (expected = ArithmeticException.class)
	public void testDivideByZeroException() {
		employeeApp.setNumberOfEmployees(0);
		employeeApp.averageSalary();
		employeeApp.setNumberOfEmployees(5);
	}

	@Test (expected = ArrayIndexOutOfBoundsException.class)
	public void testIndexException() {
		employeeApp.populateEmployeeArray(
				employeeApp.populateEmployee(6198005, "Thomas", 200000));
	}

	public static void main(String[] args) {
		TestRunner.run(new JUnit4TestAdapter(EmployeeTestCase.class));
	}
}
