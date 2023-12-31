import java.util.Stack;

class Solution {
    public int[] finalPrices(int[] prices) {
        int n= prices.length;;
        int[] ans = new int[n];

        Stack<Integer> s = new Stack<>();
        s.push(0);

        for(int i=n-1; i>= 0; i--)
        {
            int curr = prices[i];
            while (s.peek() > curr)
                s.pop();

            ans[i] = prices[i] - s.peek();
            s.push(curr);
        }
        return ans;
    }
}