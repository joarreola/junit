/**
 * 
 */
package oscar.assignment1.junit4.employee.test;

/**
 * @author Oscar Arreola
 *
 * Implements an Employee object consiting of instance properties:
 * 
 * 	id 		- employee id number
 * 	name 	- employee name
 * 	salary	- employee salary
 * 
 * Along with get() methods for each:
 * 
 * 	getName(), getSalary(), and getId()
 * 
 */
public class Employee {
	private int id;
	private String name;
	private double salary;

	/**
	 * Constructor
	 */
	public Employee(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
}
