import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public int solution(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            map.put(a, a);
        }

        if (map.size() != A.length) return 0;

        for (int i = 1; i <= A.length; i++) {
            if (map.get(i) == null) return 0;
        }
        return 1;
    }
}
