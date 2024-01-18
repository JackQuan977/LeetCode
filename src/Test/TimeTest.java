package Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeTest {

    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.now();

        // 格式化为字符串
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = dateTime.format(formatter);
        System.out.println("格式化后的日期和时间：" + formattedDateTime);

        // 解析字符串为 LocalDateTime
        String dateString = "2022-01-15 15:45:30";
        LocalDateTime parsedDateTime = LocalDateTime.parse(dateString, formatter);
        System.out.println("解析后的日期和时间：" + parsedDateTime);
    }
}
