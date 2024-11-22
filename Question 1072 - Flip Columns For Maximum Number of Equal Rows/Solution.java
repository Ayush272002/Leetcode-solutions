import java.util.*;

class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> map = new HashMap<>();
        for (int[] row : matrix) {
            StringBuilder pattern = new StringBuilder();
            for (int i = 0; i < row.length; i++) {
                pattern.append(row[0] == row[i] ? "1" : "0");
            }

            map.put(pattern.toString(), map.getOrDefault(pattern.toString(), 0) + 1);
        }

        return map.values().stream().max(Integer::compare).orElse(0);
    }
}