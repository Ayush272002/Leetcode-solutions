#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int evalRPN(vector<string> &tokens)
    {
        stack<int> st;

        for (auto &ch : tokens)
        {
            if (ch == "+" || ch == "-" || ch == "*" || ch == "/")
            {
                int num1 = st.top();
                st.pop();

                int num2 = st.top();
                st.pop();

                if (ch == "+")
                {
                    st.push(num1 + num2);
                }
                else if (ch == "-")
                {
                    st.push(num2 - num1);
                }
                else if (ch == "*")
                {
                    st.push(num1 * num2);
                }
                else
                {
                    st.push(num2 / num1);
                }
            }
            else
            {
                st.push(stoi(ch));
            }
        }

        return st.top();
    }
};