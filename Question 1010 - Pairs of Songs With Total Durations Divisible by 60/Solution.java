import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < time.length; i++) {
            int rem = time[i] % 60;

            int complement = (60 - rem) % 60;

            if (map.containsKey(complement))
                ans += map.get(complement);

            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        return ans;
    }
}