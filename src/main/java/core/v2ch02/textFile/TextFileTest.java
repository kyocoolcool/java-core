package core.v2ch02.textFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * @author Chris Chen https://blog.kyocoolcool.com
 * @version 1.0
 * @since 2020/10/26 9:22 PM
 **/
public class TextFileTest {
    public static void main(String[] args) throws IOException {
        final Employee[] employees = new Employee[3];
        employees[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
        employees[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        employees[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);
        try (var out = new PrintWriter("employee.dat", StandardCharsets.UTF_8)) {
            writeData(employees, out);
        }
        try (var in = new Scanner(new FileInputStream("employee.dat"), "UTF-8")) {
            Employee[] newStaff = readData(in);
            for (Employee employee : newStaff) {
                System.out.println(employee);
            }
        }

    }

    private static Employee[] readData(Scanner in) {
        int nextInt = in.nextInt();
        in.nextLine();
        var employees = new Employee[nextInt];
        for (int i = 0; i < nextInt; i++) {
            employees[i] = readEmployee(in);
        }
        return employees;
    }

    private static Employee readEmployee(Scanner in) {
        String line = in.nextLine();
        String[] tokens = line.split("\\|");
        String name = tokens[0];
        Integer salary = Integer.parseInt(tokens[1]);
        LocalDate hireDate=LocalDate.parse(tokens[2]);
        int year = hireDate.getYear();
        int month = hireDate.getMonthValue();
        int day = hireDate.getDayOfMonth();
        return new Employee(name, salary, year, month, day);
    }

    private static void writeData(Employee[] employees, PrintWriter out) {
        out.println(employees.length);
        for (Employee employee : employees) {
            writeEmployee(out, employee);
        }
    }

    private static void writeEmployee(PrintWriter out, Employee employee) {
        out.println(employee.getName() + "|" + employee.getSalary() + "|" + employee.getHireDay());
    }
}
