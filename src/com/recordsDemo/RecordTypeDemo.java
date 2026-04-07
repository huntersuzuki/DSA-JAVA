package com.recordsDemo;

public class RecordTypeDemo {
	public static void main(String[] args) {
		// Creating an object using traditional class.
		EmployeeClass employee = new EmployeeClass("Pranay", 78857);
//		System.out.println(employee.getName());
		System.out.println(employee);

		// Creating an object using the new "record" type.
		EmployeeRecord employeeRecord = new EmployeeRecord("Manisha", 990786);
//		System.out.println(employeeRecord.name());
		System.out.println(employeeRecord);
		System.out.println(employeeRecord.nameUpperCase());
		EmployeeRecord.printStringForExample();
	}
}
