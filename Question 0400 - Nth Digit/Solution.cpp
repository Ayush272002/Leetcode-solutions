#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int findNthDigit(int n)
    {
        long long digit = 1, base = 9, total = 0;

        while (total + base * digit < n)
        {
            total += base * digit;
            base *= 10;
            digit++;
        }

        n -= total;
        int num = pow(10, digit - 1);
        num += (n - 1) / digit;
        int idx = (n - 1) % digit;
        return to_string(num)[idx] - '0';
    }
};