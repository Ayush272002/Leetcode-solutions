import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int findTheWinner(int n, int k)
    {
        Queue<Integer> friends = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            friends.add(i);
        }

        while(!(friends.size() == 1))
        {
            for (int i = 0; i < k-1; i++) {
                friends.add(friends.poll());
            }
            friends.poll();
        }

        return friends.peek();
    }
}