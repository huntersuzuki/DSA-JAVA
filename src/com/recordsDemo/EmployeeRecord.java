package com.recordsDemo;

// The record is a certain special type of class similar to an ENUM.
// The fields of an record (which look very similar to a method arguments) 
// generate final fields just like we do in our traditional class.
// It also generates public getter methods for the fields provided, but unlike traditional getters they don't have a "get" to the method name rather just the original name of the fields.
// The record also automatically generates a all arguments constructor for the record and this type of constructor is called as a canonical constructor.
// The record will also generate a toString(),hashCode() and a equals() method for the record.
public record EmployeeRecord(String name, int employeeNumber) {

	// We can also create static fields in records.
	// Example -

	private static final String DEFAULT_EMPLOYEE_NAME = "John";

	// We cannot define a non static field in record.
	// Example -

	// private String address; // Error - Instance fields may not be declared in a
	// record class

	// We can also override the default constructor of the record.
	// Exmaple -

	public EmployeeRecord(String name, int employeeNumber) {
		if (employeeNumber < 0) {
			throw new IllegalArgumentException("Employee number cannot be negative");
		}
		this.name = name;
		this.employeeNumber = employeeNumber;

	}

	// Records also provides us with a new unique type of constructor which is
	// called a compact constructor.
	// Example -
//	public EmployeeRecord {
//		if (employeeNumber < 0) {
//			throw new IllegalArgumentException("Employee number cannot be negative");
//		}
//
//	}
	// In records we can create our own custom methods
	// Example -

	public String nameUpperCase() {
		return name.toUpperCase();
	}

	// We can also create our own static method.
	// Example -
	public static void printStringForExample() {
		System.out.println("This is test string for testing!!!");
	}
}
