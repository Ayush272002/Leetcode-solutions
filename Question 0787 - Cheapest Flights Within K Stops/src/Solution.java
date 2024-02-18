import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<Integer> distance = new ArrayList<>(Collections.nCopies(n, Integer.MAX_VALUE));
        distance.set(src, 0);

        for (int i = 0; i <= k; i++) {
            List<Integer> temp = new ArrayList<>(distance); // Create a copy of distance array before each iteration
            for (int j = 0; j < flights.length; j++) {
                int u = flights[j][0];
                int v = flights[j][1];
                int w = flights[j][2];

                if (distance.get(u) != Integer.MAX_VALUE && distance.get(u) + w < temp.get(v)) {
                    temp.set(v, distance.get(u) + w);
                }
            }
            distance = temp; // Update distance array after each iteration
        }

        return distance.get(dst) == Integer.MAX_VALUE ? -1 : distance.get(dst);
    }
}
