#include <bits/stdc++.h>
using namespace std;

class Solution
{
private:
    int rev(int x)
    {
        long long rev = 0;
        while(x > 0)
        {
            int rem = x%10;
            x /= 10;

            rev = (10*rev) + rem;
        }
        return rev;
    }
public:
    bool isPalindrome(int x)
    {
        if(x < 0) return false;

        return x == rev(x);
    }
};