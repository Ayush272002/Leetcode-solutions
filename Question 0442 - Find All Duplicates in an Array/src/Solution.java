import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<Integer> findDuplicates(int[] nums)
    {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i])>1 && !ans.contains(nums[i])) ans.add(nums[i]);
        }
        return ans;
    }
}