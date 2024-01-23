import java.util.HashMap;

class Solution {
    public int[] findErrorNums(int[] nums) 
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        int duplicate=0, missing = 0;

        for (int i = 0; i < nums.length ; i++) {
            map.put(nums[i], map.getOrDefault(nums[i] ,0)+1);
            if(map.get(nums[i]) == 2)
            {
                duplicate = nums[i];
            }
        }


        for (int i = 1; i <= nums.length; i++) {
            if (!map.containsKey(i)) {
                missing = i;
                break;
            }
        }
        return new int[]{duplicate, missing};
    }
}