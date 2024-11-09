import java.util.*;

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr1.length; i++) {
            map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);
        }

        int idx = 0;

        for (int i = 0; i < arr2.length; i++) {
            int val = arr2[i];

            int count = map.get(val);

            for (int j = 0; j < count; j++) {
                arr1[idx++] = val;
            }

            map.remove(val);
        }

        List<Integer> rem = new ArrayList<>(map.keySet());
        Collections.sort(rem);

        for (int val : rem) {
            int count = map.get(val);

            for (int j = 0; j < count; j++) {
                arr1[idx++] = val;
            }

            map.remove(val);
        }

        return arr1;
    }
}