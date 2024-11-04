#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    string compressedString(string word)
    {
        string comp;

        int ptr = 0;
        string subs;
        int count = 0;
        while (ptr < word.size())
        {
            if (subs.empty())
            {
                subs += word[ptr];
                count++;
            }
            else
            {
                if (count == 9 && word[ptr] == subs[0])
                {
                    comp.push_back(count + '0');
                    comp.push_back(subs[0]);
                    count = 0;
                    subs.clear();

                    subs += word[ptr];
                    count++;
                }
                else if (word[ptr] == subs[0] && count < 9)
                {
                    count++;
                }
                else if (word[ptr] != subs[0])
                {
                    comp.push_back(count + '0');
                    comp.push_back(subs[0]);

                    count = 0;
                    subs.clear();

                    subs += word[ptr];
                    count++;
                }
            }

            ptr++;
        }

        comp.push_back(count + '0');
        comp.push_back(subs[0]);

        return comp;
    }
};