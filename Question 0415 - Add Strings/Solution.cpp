#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    string addStrings(string num1, string num2)
    {
        int n1 = num1.size() - 1, n2 = num2.size() - 1;

        string ans = "";
        int carry = 0;

        while (n1 >= 0 || n2 >= 0 || carry > 0)
        {
            int val1 = (n1 >= 0) ? num1[n1] - '0' : 0;
            int val2 = (n2 >= 0) ? num2[n2] - '0' : 0;
            int sum = val1 + val2 + carry;

            carry = sum / 10;

            ans += to_string(sum % 10);
            n1--;
            n2--;
        }

        reverse(ans.begin(), ans.end());
        return ans;
    }
};