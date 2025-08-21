package com.dsa.exceptionHandling;

import java.io.IOException;

public class ExceptionHandling {
    public static void main(String[] args) {
        // Exception handling in Java is a mechanism to manage run-time errors,
        // ensuring normal application flow even when unexpected events (exceptions)
        // disrupt the execution. Here's a detailed explanation:

        // What Is an Exception?
        // An exception in Java is an event that interrupts the normal flow of a program's execution.
        // It can happen due to reasons like invalid user input, arithmetic errors (e.g., division by zero),
        // file handling issues, network problems, or hardware failures.

        // Exception Handling Mechanism
        // Java provides a robust exception handling mechanism using five main keywords:
        // try, catch, throw, throws, and finally:

        // try
        // The try block contains code that might throw exceptions. You place risky code here,
        // such as file operations or code that may cause arithmetic errors.

        // catch
        // A catch block follows a try block. It handles exceptions thrown by the try block.
        // Each catch block specifies a type of exception it can handle.

        try {
            int result = 10 / 0; // May throw ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("An arithmetic exception occurred: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed");
        }

        // throw
        // The throw keyword allows you to explicitly throw an exception from your code.

        throw new ArithmeticException("Explicitly thrown exception");

        // throws
        // The throws keyword appears in method signatures, declaring that a method might throw
        // certain exceptions, which must be handled elsewhere.

//        void riskyMethod() throws IOException {
//            // Code that may throw IOException
//        }

        // Multiple and Nested Exception Handling
        // Multiple catch blocks: You can use several catch blocks after a single try,
        // each catching a specific type of exception.

        // Nested try-catch: You can nest try-catch blocks to manage exceptions at different
        // levels within a program.

        // How the JVM Handles Exceptions
        // If an exception occurs inside a method, the Java Virtual Machine (JVM) creates an
        // exception object containing error details and the program’s state.

        // The JVM searches the call stack for an appropriate catch block to handle the exception.

        // If an appropriate handler is found, it passes control to that block.

        // If not, the JVM’s default handler prints the error and terminates the program abnormally.

        // Example: Division by Zero
//        try {
//            int ans = 10 / 0;
//            System.out.println("Answer: " + ans);
//        } catch (ArithmeticException e) {
//            System.out.println("Error: Division by zero is not allowed!");
//        } finally {
//            System.out.println("Program continues after handling the exception.");
//        }

        // Output:
        // Error: Division by zero is not allowed!
        // Program continues after handling the exception.
        // The code continues execution after handling the exception due to the finally block.

        // Advantages of Exception Handling
        // Maintains program flow by handling run-time errors gracefully
        // Separates error-handling code from regular logic
        // Provides meaningful error reporting and debugging information
        // Categorizes errors by type

        // Exception vs. Error
        // Exception
        // Indicates serious problems, not usually handled by applications (e.g., OutOfMemoryError)
        // Conditions that applications might want to catch (e.g., IOException)

        // Summary Table of Keywords
        // Keyword Purpose
        // try Wraps code that might throw an exception
        // catch Handles specific exception types thrown from try
        // finally Executes cleanup code, always runs after try/catch
        // throw Explicitly throws an exception
        // throws Declares exceptions a method may throw

        // Exception handling is a vital part of writing robust Java applications,
        // making them fault-tolerant and reliable.
    }
}
