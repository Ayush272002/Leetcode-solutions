#include<bits/stdc++.h>
using namespace std;

class Solution 
{
public:
    int lengthOfLastWord(string s) 
    {
        int n = s.size()-1;
        while(s[n] == ' ') n--;
        int len = 0;
        while(n >= 0 && s[n] != ' ')
        {
            n--;
            len++;
        }

        return len;
    }
};