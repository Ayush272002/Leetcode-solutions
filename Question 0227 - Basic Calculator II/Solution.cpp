#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int calculate(string s)
    {
        stack<int> st;
        char op = '+';
        int number = 0;

        for (int i = 0; i < s.size(); i++)
        {
            char val = s[i];
            if (isdigit(val))
                number = (number * 10) + (val - '0');

            if ((!isdigit(val) && val != ' ') || (i == s.size() - 1))
            {
                if (op == '+')
                    st.push(number);
                else if (op == '-')
                    st.push(-number);
                else if (op == '*')
                {
                    int top = st.top();
                    st.pop();
                    st.push(number * top);
                }
                else if (op == '/')
                {
                    int top = st.top();
                    st.pop();
                    st.push(top / number);
                }

                number = 0;
                op = val;
            }
        }

        int ans = 0;
        while (!st.empty())
        {
            int top = st.top();
            st.pop();
            ans += top;
        }

        return ans;
    }
};