#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    vector<int> twoSum(vector<int> &numbers, int target)
    {
        vector<int> ans;

        for (int i = 0; i < numbers.size(); i++)
        {
            int x = numbers[i];

            int y = target - x;

            int start = i + 1;
            int end = numbers.size() - 1;
            int mid = (start + (end - start) / 2);

            while (start <= end)
            {
                if (numbers[mid] == y)
                {
                    ans.push_back(i + 1);
                    ans.push_back(mid + 1);
                    return ans;
                }

                if (numbers[mid] > y)
                {
                    end = mid - 1;
                }
                else if (numbers[mid] < y)
                {
                    start = mid + 1;
                }

                mid = (start + (end - start) / 2);
            }
        }

        return ans;
    }
};