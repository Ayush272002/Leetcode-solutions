import java.util.*;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if (nums.length == 0)
            return ans;

        StringBuilder list = new StringBuilder();
        int count = 1;
        list.append(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1)
                count++;
            else {
                if (count > 1) {
                    list.append("->");
                    list.append(nums[i - 1]);
                }
                count = 1;
                ans.add(list.toString());
                list = new StringBuilder();
                list.append(nums[i]);
            }
        }

        if (count > 1) {
            list.append("->");
            list.append(nums[nums.length - 1]);
        }
        ans.add(list.toString());

        return ans;
    }
}