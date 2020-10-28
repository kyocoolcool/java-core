package core.v2ch02.randomAccess;

import core.v2ch02.textFile.DataIO;
import core.v2ch02.textFile.Employee;
import lombok.Data;

import java.io.*;
import java.time.LocalDate;

/**
 * @author Chris Chen https://blog.kyocoolcool.com
 * @version 1.0
 * @since 2020/10/27 7:44 PM
 **/
public class RandomAccessTest {
    public static void main(String[] args) throws IOException {
        final Employee[] employees = new Employee[3];
        employees[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
        employees[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        employees[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);

        try (var out = new DataOutputStream(new FileOutputStream("employee.dat"))) {
            for (Employee employee : employees) {
                writeData(out, employee);
            }
        }
        try (var in = new RandomAccessFile("employee.dat", "r")) {
            int n = (int) (in.length() / Employee.RECORD_SIZE);
            var newStaff = new Employee[n];
            for (int i = 0; i < n; i++) {
                newStaff[i] = new Employee();
                in.seek(i * Employee.RECORD_SIZE);
                newStaff[i] = readData(in);
            }
            System.out.println("newStaff[0]:"+newStaff[0]);
            System.out.println("newStaff[1]:"+newStaff[1]);
            System.out.println("newStaff[2]:"+newStaff[2]);

        }
        ;
    }

    private static Employee readData(RandomAccessFile in) throws IOException {
        String name = DataIO.readFixedString(Employee.NAME_SIZE, in);
        int salary = in.readInt();
        int y = in.readInt();
        int m = in.readInt();
        int d = in.readInt();
        return new Employee(name, salary, y, m - 1, d);
    }

    private static void writeData(DataOutputStream out, Employee employee) throws IOException {
        DataIO.writeFixedString(employee.getName(), Employee.NAME_SIZE, out);
        out.writeInt(employee.getSalary());
        final LocalDate hireDay = employee.getHireDay();
        out.writeInt(hireDay.getYear());
        out.writeInt(hireDay.getMonthValue());
        out.writeInt(hireDay.getDayOfMonth());
    }
}
