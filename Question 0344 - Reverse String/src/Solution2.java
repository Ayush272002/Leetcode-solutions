//solved using stacks

import java.util.Stack;

public class Solution2 {
    public void reverseString(char[] s)
    {
        Stack<Character> stack= new Stack<>();
        for (int i = 0; i < s.length; i++) {
            stack.push(s[i]);
        }

        int i=0;
        while (!stack.empty() && i<s.length)
        {
            s[i] = stack.pop();
            i++;

        }
    }
}
