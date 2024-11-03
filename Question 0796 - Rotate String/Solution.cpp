#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    bool rotateString(string s, string goal)
    {
        // if (s.size() != goal.size())
        //     return false;

        // for (int i = 0; i < s.size(); i++)
        // {
        //     if (s == goal)
        //         return true;
        //     else
        //     {
        //         s.push_back(s[0]);
        //         s.erase(0, 1);
        //     }
        // }

        // return false;

        return s.size() == goal.size() && (s + s).find(goal) != string::npos;
    }
};