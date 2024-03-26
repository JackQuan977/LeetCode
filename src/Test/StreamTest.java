package Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: quanli
 * @description: TODO
 * @date: 2024/2/13 15:39
 * @version: 1.0
 */
public class StreamTest {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> doubledNumbers = numbers.stream()
                .map(n -> n * 2)
                .collect(Collectors.toList());
        System.out.println(doubledNumbers); // 输出：[2, 4, 6, 8, 10]
    }
}
