import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int slidingPuzzle(int[][] board) {
        String ans = "123450";

        String curr = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                curr += board[i][j];
            }
        }

        if (curr == ans)
            return 0;

        HashSet<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        int[][] dir = { { 1, 3 }, { 0, 2, 4 }, { 1, 5 }, { 0, 4 }, { 1, 3, 5 }, { 2, 4 } };

        set.add(curr);
        q.add(curr);

        int moves = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String temp = q.poll();

                if (temp.equals(ans))
                    return moves;

                int posOfZero = 0;
                for (int j = 0; j < temp.length(); j++) {
                    if (temp.charAt(j) == '0')
                        posOfZero = j;
                }

                int[] pos = dir[posOfZero];

                for (int d : pos) {

                    StringBuilder copy = new StringBuilder(temp);
                    char zero = temp.charAt(posOfZero);
                    char swap = temp.charAt(d);

                    copy.setCharAt(posOfZero, swap);
                    copy.setCharAt(d, zero);

                    if (!set.contains(copy.toString())) {
                        q.add(copy.toString());
                        set.add(copy.toString());
                    }
                }
            }
            moves++;
        }

        return -1;
    }
}