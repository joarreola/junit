/**
 * 
 */
package oscar.assignment1.junit4.employee.test;


/**
 * @author Oscar Arreola
 *
 * Employee application which computes the min, max, and average of 5
 * employees’ salaries then prints the computed values.
 * 
 * Constructor initialization for instance variables:
 * 
 * 	numberOfEmployees		- number of employees to work with
 * 	employeeArray			- empty array to hold Employee objects, size of
 * 							  numberOfEmployees
 * 	
 * 
 * Implements methods:
 * 
 * 	setNumberOfEmployees()	- Sets instance variable NumberOfEmployees
 * 	populateEmployee()		- Creates an Employee instance with id, name, and
 * 							  salary
 * 	populateEmployeeArray()	- Adds an Employee object to array employeeArray[]
 *  minimumSalaray()		- Calculates the minimum salary of employees in
 *  						  employeeArray[].
 *  maximumSalaray()		- Calculates the maximum salary of employees in
 *  						  employeeArray[].
 *  averageSalaray()		- Calculates the average salary of employees in
 *  						  employeeArray[].throws ArithmeticException on a
 *  						  divide-by-zero condition
 *  main()					- Creates an instance of EmployeeApp. populate 5
 *  						  Employee instances. populates an employeeArray[]
 *  						  array with the 5 Employee instances. Computes and
 *  						  prints the minimum, maximum, and average salary.
 *
 */
public class EmployeeApp {
	int numberOfEmployees;
	private int employeeIndex = 0;
	Employee [] employeeArray;

	/**
	 * Constructor
	 * 
	 * @param numberOfEmployees
	 * @param employeeArray
	 */
	public EmployeeApp(int numberOfEmployees) throws ArithmeticException {
		super();
		this.numberOfEmployees = numberOfEmployees;
		this.employeeArray = new Employee[numberOfEmployees];
	}

	/**
	 * @param numberOfEmployees the numberOfEmployees to set
	 */
	public final void setNumberOfEmployees(int numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	/**
	 * Create an Employee instance with id, name, and salary.
	 * 
	 * @param id
	 * @param name
	 * @param salary
	 * @return an Employee instance
	 */
	public Employee populateEmployee(int id, String name, double salary) {
		
		return (new Employee(id, name, salary));
	}
	
	/**
	 * Add an Employee object to array employeeArray[].
	 * Allow a potential ArrayIndexOutOfBoundsException exception to
	 * be passed up.
	 * 
	 * @param employee
	 */
	public void populateEmployeeArray(Employee employee) {
		this.employeeArray[employeeIndex++] = employee;
	}

	/**
	 * Calculate the minimum salary of employees in array employeeArray[].
	 * 
	 * @return min
	 */
	public double minimumSalaray() {
		double min = 0;

		for (int i=0; i < employeeArray.length; i++) {
			if (i == 0)
				min = employeeArray[i].getSalary();
			if (employeeArray[i].getSalary() < min)
				min = employeeArray[i].getSalary();
		}

		return min;
	}

	/**
	 * Calculate the maximum salary of employees in array employeeArray[].
	 * 
	 * @return max
	 */
	public double maximumSalaray() {
		double max = 0;

		for (int i = 0; i < employeeArray.length; i++) {
			if (i == 0)
				max = employeeArray[i].getSalary();
			if (employeeArray[i].getSalary() > max)
				max = employeeArray[i].getSalary();
		}

		return max;	
	}

	/**
	 * Calculate the average salary of employees in array employeeArray[].
	 * Throw an ArithmeticException on a divide-by-zero condition
	 * (average is set to Double.POSITIVE_INFINITY).
	 * 
	 * @exception ArithmeticException
	 * @return average
	 */
	public double averageSalary() throws ArithmeticException {
		double total = 0;
		double average = 0;
		for (int i = 0; i < employeeArray.length; i++) {
			total = total + employeeArray[i].getSalary();
		}
		average = total / numberOfEmployees;
		
		if(average == Double.POSITIVE_INFINITY)
            throw new ArithmeticException("Divide by Zero");
		
		return average;		
	}

	/**
	 * Create an instance of EmployeeApp. Populate 5 Employee instances.
	 * Populate an employeeArray[] array with the 5 Employee instances.
	 * 
	 * Compute and print the minimum, maximum, and average salary.
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws ArithmeticException {
		double minimumSalary;
		double maximumSalary;
		double averageSalary;
		Employee peter;
		Employee jane;
		Employee jim;
		Employee albert;
		Employee thomas;

		EmployeeApp employeeApp = new EmployeeApp(5);
		
		// populate Employee objects
		peter  = employeeApp.populateEmployee(6198001, "Peter",  500000);
		jane   = employeeApp.populateEmployee(6198002, "Jane",    95000);
		jim    = employeeApp.populateEmployee(6198003, "Jim",     85000);
		albert = employeeApp.populateEmployee(6198004, "Albert", 150000);
		thomas = employeeApp.populateEmployee(6198005, "Thomas", 200000);

		// populate Array of Employee objects
		employeeApp.populateEmployeeArray(peter);
		employeeApp.populateEmployeeArray(jane);
		employeeApp.populateEmployeeArray(jim);
		employeeApp.populateEmployeeArray(albert);
		employeeApp.populateEmployeeArray(thomas);

		System.out.printf("Employee   \tId \t\tSalary \n");
		System.out.println("-----------------------------------------");
		for (int i=0; i < employeeApp.employeeArray.length; i++) {
			System.out.printf("%s     \t%d \t%6.0f \n",
				employeeApp.employeeArray[i].getName(),
				employeeApp.employeeArray[i].getId(),
				employeeApp.employeeArray[i].getSalary());
		}
		System.out.println("-----------------------------------------");
		
		// calculate the minimum salary of employees
		minimumSalary = employeeApp.minimumSalaray();
		
		// calculate the maximum salary of employees
		maximumSalary = employeeApp.maximumSalaray();
		
		// calculate the average salary of employees
		averageSalary = employeeApp.averageSalary();
		
		// print statistics
		System.out.printf("Minimum Salary: %.0f\nMaximum Salary: %.0f\n" +
				"Average Salary: %.2f\n", minimumSalary, maximumSalary,
				averageSalary);

	}

}
