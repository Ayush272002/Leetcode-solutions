#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int minimizeXor(int num1, int num2)
    {
        int ans = 0, targetSetBits = __builtin_popcount(num2);

        for (int i = 31; i >= 0 && targetSetBits > 0; i--)
        {
            if (num1 & (1 << i))
            {
                ans |= (1 << i);
                targetSetBits--;
            }
        }

        for (int i = 0; i < 32 && targetSetBits > 0; i++)
        {
            if (!(ans & (1 << i)))
            {
                ans |= (1 << i);
                targetSetBits--;
            }
        }

        return ans;
    }
};