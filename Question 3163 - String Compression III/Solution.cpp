#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    string compressedString(string word)
    {
        string comp;
        int ptr = 0;
        while (ptr < word.size())
        {
            char curr = word[ptr];
            int count = 0;

            while (ptr < word.size() && word[ptr] == curr && count < 9)
            {
                count++;
                ptr++;
            }

            comp.push_back(count + '0');
            comp.push_back(curr);
        }

        return comp;
    }
};