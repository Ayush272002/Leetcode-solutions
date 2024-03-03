import java.util.ArrayList;
import java.util.List;

class Solution
{
    private void solve(List<String> ans, StringBuilder parenthesis, int opening, int closing)
    {
        //base case
        if(opening == 0 && closing == 0)
        {
            ans.add(parenthesis.toString());
            return;
        }

        if(opening > 0)
        {
            parenthesis.append("(");
            solve(ans,parenthesis,opening-1,closing);
            parenthesis.deleteCharAt(parenthesis.length()-1);
        }
        if(closing > opening)
        {
            parenthesis.append(")");
            solve(ans,parenthesis,opening,closing-1);
            parenthesis.deleteCharAt(parenthesis.length()-1);
        }


    }
    public List<String> generateParenthesis(int n)
    {
        List<String> ans = new ArrayList<>();
        StringBuilder parenthesis = new StringBuilder();
        solve(ans,parenthesis,n,n);
        return ans;
    }
}