package Streams;

/*
Write a java code for Finding the Second Highest Salary from a List of Employees

Input:
======
4
Alice
50000
Bob
60000
Charlie
55000
David
60000

Output:
=======
Second highest salary: 55000.0

*/

import java.util.*;
import java.util.stream.*;

class Employee {
    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}

public class Streams2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        int numEmployees = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numEmployees; i++) {
            String name = scanner.nextLine();
            double salary = Double.parseDouble(scanner.nextLine());
            employees.add(new Employee(name, salary));
        }

        // Complete the code here.
        List<Double> res = employees.stream()
        .map(Employee::getSalary)
        .distinct()
        .sorted(Comparator.reverseOrder())
        .collect(Collectors.toList());
        System.out.println("Second highest salary: "+ res.get(1));
    }
}

