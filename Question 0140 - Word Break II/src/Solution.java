import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution
{
    private void solve(int start, int end, String s, List<String> curr, List<String> ans, Set<String> words)
    {
        if(end == s.length()-1)
        {
            if(words.contains(s.substring(start, end+1)))
            {
                curr.add(s.substring(start, end+1));
                ans.add(String.join(" ", curr));
                curr.remove(curr.size()-1);
            }
            return;
        }

        //take
        if(words.contains(s.substring(start, end+1)))
        {
            curr.add((s.substring(start, end+1)));
            solve(end+1, end+1, s, curr, ans, words);
            curr.remove(curr.size()-1);
        }

        //skip
        solve(start, end+1, s, curr, ans, words);
    }
    public List<String> wordBreak(String s, List<String> wordDict)
    {
        Set<String> set = new HashSet<>(wordDict);
        List<String> ans = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        solve(0, 0, s, curr, ans, set);
        return ans;
    }
}