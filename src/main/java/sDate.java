import java.sql.Date;
import java.time.LocalDate;

public class sDate {
    public static void main(String[] args) {
        LocalDate jakasData = LocalDate.of(2014, 8, 14);
        Date sqlDate = Date.valueOf(jakasData);
        System.out.println(sqlDate);
    }
}