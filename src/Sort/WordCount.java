package Sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCount {
    public Map<Integer, Integer> count(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int count = map.get(nums[i]);
                map.put(nums[i], count + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        return map;
    }
}
