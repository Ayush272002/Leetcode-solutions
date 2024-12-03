import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> st = new HashSet<>();

        for (int n : arr) {
            if (st.contains(n * 2) || (n % 2 == 0 && st.contains(n / 2)))
                return true;

            st.add(n);
        }
        return false;
    }
}