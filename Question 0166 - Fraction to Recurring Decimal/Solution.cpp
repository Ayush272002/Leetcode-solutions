#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    string fractionToDecimal(int numerator, int denominator)
    {
        if (numerator == 0)
            return "0";

        string ans;
        if (numerator * denominator < 0)
            ans += "-";

        long long n = abs(numerator);
        long long d = abs(denominator);
        long long rem = n % d;

        ans += to_string(n / d);
        if (rem == 0)
            return ans;

        ans += '.';

        unordered_map<long long, int> map;

        while (rem != 0)
        {
            if (map.find(rem) != map.end())
            {
                ans.insert(map[rem], "(");
                ans += ")";
                break;
            }

            map[rem] = ans.size();

            rem *= 10;
            ans += to_string(rem / d);
            rem %= d;
        }

        return ans;
    }
};