import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    private void solve(String digits, HashMap<Integer, String> map, List<String> ans)
    {
        
    }
    public List<String> letterCombinations(String digits)
    {
        HashMap<Integer, String> map = new HashMap<>();

        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");

        List<String> ans = new ArrayList<>();
        solve(digits, map, ans);
        return ans;
    }
}