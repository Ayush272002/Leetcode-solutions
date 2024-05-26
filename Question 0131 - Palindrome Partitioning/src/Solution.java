import java.util.ArrayList;
import java.util.List;

class Solution
{
    private void solve(String s, List<List<String>> ans, List<String> curr, int idx)
    {
        //base case
        if(idx >= s.length())
        {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i = idx; i < s.length(); i++)
        {
            String temp = s.substring(idx, i+1);
            if(isPalindrome(temp))
            {
                curr.add(temp);
                solve(s, ans, curr, i+1);
                curr.remove(curr.size()-1);
            }
        }
    }

    private boolean isPalindrome(String st)
    {
        if(st.length() == 1) return true;

        int s = 0, e = st.length()-1;
        while (s < e)
        {
            if(st.charAt(s) != st.charAt(e)) return false;
            s++;
            e--;
        }

        return true;
    }

    public List<List<String>> partition(String s)
    {
        List<List<String>> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();

        solve(s, ans, temp, 0);
        return ans;
    }
}