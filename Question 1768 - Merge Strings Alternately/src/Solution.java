import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String mergeAlternately(String word1, String word2) {
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        StringBuilder sb = new StringBuilder();

        Queue<Character> q1 = new LinkedList<>();
        Queue<Character> q2 = new LinkedList<>();

        for (int i = 0; i < w1.length; i++) {
            q1.add(w1[i]);
        }

        for (int i = 0; i < w2.length; i++) {
            q2.add(w2[i]);
        }

        while(!q1.isEmpty() || !q2.isEmpty())
        {
            if(!q1.isEmpty())sb.append(q1.poll());
            if(!q1.isEmpty()) sb.append(q2.poll());
        }
        return sb.toString();
    }
}

//Time and space complexity is O(N)