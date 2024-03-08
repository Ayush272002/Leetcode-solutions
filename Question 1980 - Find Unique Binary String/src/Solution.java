import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution
{
    private boolean solve(Set<String> num, int n, StringBuilder ans)
    {
        if(n == ans.length() && !num.contains(ans.toString())) return true;
        else if(n == ans.length() && num.contains(ans.toString())) return false;

        ans.append('1');
        if(solve(num,n,ans)) return true;
        ans.deleteCharAt(ans.length()-1);

        ans.append('0');
        if(solve(num,n,ans)) return true;
        ans.deleteCharAt(ans.length()-1);

        return false;
    }
    public String findDifferentBinaryString(String[] nums)
    {
        int n = nums[0].length();
        StringBuilder ans = new StringBuilder();
        Set<String> num = new HashSet<>(Arrays.asList(nums));

        boolean flag = solve(num,n, ans);
        if(!flag)
        {
            for (int i = 0; i < n; i++) {
                ans.append('0');
                return ans.toString();
            }
        }

        return ans.toString();
    }
}