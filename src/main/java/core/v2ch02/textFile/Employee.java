package core.v2ch02.textFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Chris Chen https://blog.kyocoolcool.com
 * @version 1.0
 * @since 2020/10/26 9:22 PM
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee  implements Serializable{
    private static final long serialVersionUID = -6623054776936140266L;
    public static final int NAME_SIZE = 40;
    public static final int RECORD_SIZE = 2 * NAME_SIZE + 8 + 4 + 4 + 4;
    String name;
    Integer salary;
    Integer year;
    Integer month;
    Integer day;

    public LocalDate getHireDay() {
        return LocalDate.of(year, month, day);
    }

    public void raiseSalary(int i) {
        this.salary += i;
    }
}

