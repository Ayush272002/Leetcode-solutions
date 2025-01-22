#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    bool canConstruct(string ransomNote, string magazine)
    {
        vector<int> count(26, 0);

        for (int i = 0; i < ransomNote.size(); i++)
        {
            count[ransomNote[i] - 'a']++;
        }

        for (int i = 0; i < magazine.size(); i++)
        {
            if (count[magazine[i] - 'a'])
                count[magazine[i] - 'a']--;
        }

        return accumulate(count.begin(), count.end(), 0) == 0;
    }
};