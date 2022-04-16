package Test;

import java.util.HashMap;

public class DebugTest {
    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
        HashMap<String,String> map = new HashMap<>();
        map.put("a","2");
        map.put("b","2");
        map.put("c","2");
        String a = map.get("a");
        System.out.println(a);
        map.remove("b");
        System.out.println(map);
    }
}
