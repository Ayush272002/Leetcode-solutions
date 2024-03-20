import java.util.ArrayList;
import java.util.List;

class Solution
{
    public int[] singleNumber(int[] nums)
    {
        int n = nums.length;
        int res = 0;

        for (int i = 0; i < n; i++) {
            res ^= nums[i];
        }

        int index = 0;
        while((res & (1<<index)) == 0)
        {
            index++;
        }

        int mask = (1<<index);
        List<Integer> tempArr = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            if((nums[i] & mask) != 0) tempArr.add(nums[i]);
        }

        int first = 0;
        for (int i = 0; i < tempArr.size(); i++) {
            first ^= tempArr.get(i);
        }

        int second = res ^ first;
        return new int[]{first,second};
    }
}