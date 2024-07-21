/* 
Write a Java Code to perform Grouping Employees by Department and Counting Them

Input:
======
3
Alice
HR
Bob
IT
Charlie
HR

Output:
=======
HR: 2
IT: 1
*/

import java.util.*;
import java.util.stream.*;

class Employee {
    String name;
    String department;

    Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        int numEmployees = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numEmployees; i++) {
            String name = scanner.nextLine();
            String department = scanner.nextLine();
            employees.add(new Employee(name, department));
        }
       // Complete the code here. 
       Map<String,Long> m1=employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
       System.out.println(m1);
    }
}
