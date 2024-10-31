#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int romanToInt(string s)
    {
        unordered_map<char, int> map;
        map['I'] = 1;
        map['V'] = 5;
        map['X'] = 10;
        map['L'] = 50;
        map['C'] = 100;
        map['D'] = 500;
        map['M'] = 1000;

        int val = 0;
        for (int i = 0; i < s.size(); ++i)
        {
            if (i + 1 < s.size())
            {
                if (s[i] == 'I' && s[i + 1] == 'V')
                {
                    val += 4;
                    i++;
                }
                else if (s[i] == 'I' && s[i + 1] == 'X')
                {
                    val += 9;
                    i++;
                }
                else if (s[i] == 'X' && s[i + 1] == 'L')
                {
                    val += 40;
                    i++;
                }
                else if (s[i] == 'X' && s[i + 1] == 'C')
                {
                    val += 90;
                    i++;
                }
                else if (s[i] == 'C' && s[i + 1] == 'D')
                {
                    val += 400;
                    i++;
                }
                else if (s[i] == 'C' && s[i + 1] == 'M')
                {
                    val += 900;
                    i++;
                }
                else
                {
                    val += map[s[i]];
                }
            }
            else
            {
                val += map[s[i]];
            }
        }

        return val;
    }
};