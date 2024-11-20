#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int takeCharacters(string s, int k)
    {
        if (k == 0)
            return 0;

        vector<int> count(3, 0);
        for (char ch : s)
        {
            count[ch - 'a']++;
        }

        for (int c : count)
        {
            if (c < k)
                return -1;
        }

        int n = s.size(), minutes = n, i = 0, j = 0;
        while (i <= j && j < n)
        {
            count[s[j] - 'a']--;

            while (i <= j && count[0] < k || count[1] < k || count[2] < k)
            {
                count[s[i] - 'a']++;
                i++;
            }

            minutes = min(minutes, n - (j - i + 1));
            j++;
        }

        return minutes;
    }
};