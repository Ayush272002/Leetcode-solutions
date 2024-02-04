import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    private void solve(String digits,StringBuilder output,int index, HashMap<Integer, String> map, List<String> ans)
    {
        //base case
        if(index >= digits.length())
        {
            ans.add(output.toString());
            return;
        }


        int num = Integer.parseInt(String.valueOf(digits.charAt(index)));
        String val = map.get(num);

        for (int i = 0; i < val.length(); i++) {
            output.append(val.charAt(i));
            solve(digits,output,index+1,map,ans);
            output.deleteCharAt(output.length()-1);
        }

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

        StringBuilder output = new StringBuilder();
        List<String> ans = new ArrayList<>();
        int index = 0;
        if(digits.isEmpty()) return ans;
        solve(digits,output,index, map, ans);
        return ans;
    }
}