package core.v2ch02.serialClone;

import core.v2ch02.textFile.Employee;
import lombok.extern.java.Log;

import java.io.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;

/**
 * @author Chris Chen https://blog.kyocoolcool.com
 * @version 1.0
 * @since 2020/10/29 4:54 PM
 **/
@Log
public class SerialCloneTest {
    public static void main(String[] args) throws CloneNotSupportedException, InterruptedException {
        var before = LocalDateTime.now();
//        var manager = new Manager("boss");
//        var harry = new Employee2("Harry Hacker", 35000, 1989, 10, 1, manager);
        var harry = new Employee2("Harry Hacker", 35000, 1989, 10, 1);
        var harry2=(Employee2)harry.clone();
//        var harry2 = new Employee2(harry.getName(), harry.getSalary(), harry.getHireDay().getYear(), harry.getHireDay().getMonthValue(), harry.getHireDay().getDayOfMonth(), manager);
//        var harry2 = new Employee2(harry.getName(), harry.getSalary(), harry.getHireDay().getYear(), harry.getHireDay().getMonthValue(), harry.getHireDay().getDayOfMonth());
        harry.raiseSalary(10);
        log.info(harry.toString());
        log.info(harry2.toString());
        Thread.sleep(10000);
        var after = LocalDateTime.now();
        System.out.println(Duration.between(before, after).getNano());
    }
}

class SerialCloneable implements Cloneable, Serializable {
    public Object clone() throws CloneNotSupportedException {
        try {
            // save the object to a byte array
            var bout = new ByteArrayOutputStream();
            try (var out = new ObjectOutputStream(bout)) {
                out.writeObject(this);
            }

            // read a clone of the object from the byte array
            try (var bin = new ByteArrayInputStream(bout.toByteArray())) {
                var in = new ObjectInputStream(bin);
                return in.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            var e2 = new CloneNotSupportedException();
            e2.initCause(e);
            throw e2;
        }
    }
}

class Employee2 extends SerialCloneable {
    private String name;
    private double salary;
    private LocalDate hireDay;
    private Manager manager;

    public Employee2(String n, double s, int year, int month, int day) {
        name = n;
        salary = s;
        hireDay = LocalDate.of(year, month, day);
    }

    public Employee2(String n, double s, int year, int month, int day, Manager manager) {
        name = n;
        salary = s;
        hireDay = LocalDate.of(year, month, day);
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }


    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public String toString() {
        return getClass().getName()
                + "[name=" + name
                + ",salary=" + salary
                + ",hireDay=" + hireDay
                + ",manager=" + manager
                + "]";
    }

}

class Manager implements Serializable {

    public Manager(String title) {
        this.title = title;
    }

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "title='" + title + '\'' +
                '}';
    }
}


