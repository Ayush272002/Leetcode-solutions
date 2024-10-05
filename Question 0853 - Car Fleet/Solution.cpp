#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int carFleet(int target, vector<int> &position, vector<int> &speed)
    {
        vector<pair<int, int>> cars;
        stack<double> st;
        ;

        for (int i = 0; i < speed.size(); i++)
        {
            pair<int, int> p;
            p.first = position[i];
            p.second = speed[i];
            cars.push_back(p);
        }

        sort(cars.begin(), cars.end());

        for (int i = 0; i < cars.size(); i++)
        {
            double t = (double)(target - cars[i].first) / cars[i].second;
            if (st.empty())
                st.push(t);
            else
            {
                while (!st.empty() && t >= st.top())
                {
                    st.pop();
                }

                st.push(t);
            }
        }

        return st.size();
    }
};