import java.util.PriorityQueue;

class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders)
    {
        int count = 0;
        PriorityQueue<Integer> usedLadder = new PriorityQueue<>();
        for (int i = 0; i < heights.length - 1; i++) {
            int diff = heights[i+1] - heights[i];
            if(diff <= 0) continue;

            if(ladders > 0)
            {
                usedLadder.add(diff);
                ladders--;
            }
            else if(!usedLadder.isEmpty() && diff > usedLadder.peek())
            {
                bricks -= usedLadder.poll();
                usedLadder.add(diff);
            }
            else bricks -= diff;
            if(bricks < 0) return i;
        }
        return heights.length-1;
    }
}