#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    string decodeString(string s)
    {
        string str = "", count = "";
        stack<char> st;

        for (int i = 0; i < s.size(); i++)
        {
            char ch = s[i];

            if (ch == ']')
            {
                while (st.top() != '[')
                {
                    str = st.top() + str;
                    st.pop();
                }

                st.pop();

                while (!st.empty() && isdigit(st.top()))
                {
                    count = st.top() + count;
                    st.pop();
                }

                int num = stoi(count);

                while (num--)
                {
                    for (char it : str)
                        st.push(it);
                }

                str = "";
                count = "";
            }
            else
            {
                st.push(ch);
            }
        }

        string ans = "";
        while (!st.empty())
        {
            ans = st.top() + ans;
            st.pop();
        }

        return ans;
    }
};