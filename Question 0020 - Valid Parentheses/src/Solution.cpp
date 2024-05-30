#include<bits/stdc++.h>
using namespace std;

class Solution 
{
public:
    bool isValid(string s) 
    {
        stack<char> st;
        for(int i = 0; i < s.size(); i++)
        {
            if(st.empty()) 
            {
                st.push(s[i]);
                continue;
            }

            if(s[i] == ')')
            {
                if(st.top() == '(') st.pop();
                else return false;
            }
            else if(s[i] == ']')
            {
                if(st.top() == '[') st.pop();
                else return false;
            }
            else if(s[i] == '}')
            {
                if(st.top() == '{') st.pop();
                else return false;
            }
            else st.push(s[i]);
        }

        return st.empty();
    }
};