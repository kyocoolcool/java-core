package core.v2ch02.objectStream;

import core.v2ch02.textFile.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Chris Chen https://blog.kyocoolcool.com
 * @version 1.0
 * @since 2020/10/29 2:20 PM
 **/
@Data
@NoArgsConstructor
public class Manager extends Employee {
    private Employee secretary;

    public Manager(String name, Integer salary, Integer year, Integer month, Integer day) {
        super(name, salary, year, month, day);
    }

    public Manager(Employee secretary) {
        this.secretary = secretary;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name=" + getName() +","+
                "salary=" + getSalary() +","+
                "name=" + getName() +","+
                "year=" + getYear() +","+
                "month=" + getMonth() +","+
                "day=" + getDay() +","+
                "secretary=" + secretary +
                '}';
    }
}
