import java.util.ArrayList;
import java.util.Collections;

class Solution {
    class Pair implements Comparable<Pair> {
        int first;
        char second;

        Pair(int first, char second) {
            this.first = first;
            this.second = second;
        }

        public int compareTo(Pair p) {
            return this.first - p.first;
        }
    }

    public String restoreString(String s, int[] indices) {
        ArrayList<Pair> list = new ArrayList<>();

        for (int i = 0; i < indices.length; i++) {
            list.add(new Pair(indices[i], s.charAt(i)));
        }
        
        Collections.sort(list);
        String ans = "";

        for (int i = 0; i < list.size(); i++) {
            ans += list.get(i).second;
        }

        return ans;
    }
}