import java.util.ArrayList;
import java.util.List;

class Solution
{
    private void solve(List<String> ans, StringBuilder word, String s, int i)
    {
        if(word.length()==s.length())
        {
            String k = word.toString();
            ans.add(k);
            return;
        }

        if(Character.isAlphabetic(s.charAt(i)))
        {
            word.append(Character.toUpperCase(s.charAt(i)));
            solve(ans,word,s,i+1);
            word.deleteCharAt(word.length()-1);

            word.append(Character.toLowerCase(s.charAt(i)));
            solve(ans,word,s,i+1);
            word.deleteCharAt(word.length()-1);
        }
        else
        {
            word.append(s.charAt(i));
            solve(ans,word,s,i+1);
            word.deleteCharAt(word.length()-1);
        }
    }
    public List<String> letterCasePermutation(String s)
    {
        List<String> ans = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        int index = 0;
        solve(ans,word,s, index);
        return ans;
    }
}