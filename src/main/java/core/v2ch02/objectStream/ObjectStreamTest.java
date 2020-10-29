package core.v2ch02.objectStream;

import core.v2ch02.textFile.Employee;
import lombok.extern.java.Log;

import java.io.*;

/**
 * @author Chris Chen https://blog.kyocoolcool.com
 * @version 1.0
 * @since 2020/10/29 2:19 PM
 **/
@Log
public class ObjectStreamTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        var harry = new Employee("Harry Hacker",
                50000, 1989, 10, 1);
        var carl = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        carl.setSecretary(harry);
        var tony = new Manager("Tony Tester", 40000,
                1990, 3, 15);
        tony.setSecretary(harry);
        var staff = new Employee[3];
        staff[0] = carl;
        staff[1] = harry;
        staff[2] = tony;
        try (var out = new ObjectOutputStream(new
                FileOutputStream("employee4.dat"))) {
        out.writeObject(staff);
        }

        try (var in=new ObjectInputStream(new FileInputStream("employee4.dat"))){
            var newStaff = (Employee[]) in.readObject();
            newStaff[1].raiseSalary(10);
            for (Employee employee : newStaff) {
                log.info(employee.toString());
            }

        }
    }
}
