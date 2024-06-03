#include<bits/stdc++.h>
using namespace std;
#define vi vector<int>
#define pb push_back

class Solution 
{
public:
    int trap(vector<int>& height) 
    {
        vi prefix;
        vi suffix;
        int n = height.size();

        prefix.pb(height[0]);
        for(int i = 1; i < n; i++) prefix.pb(max(prefix[i-1], height[i]));

        suffix.pb(height[n-1]);
        for(int i = n-2, j = 0; i >= 0; i--, j++) suffix.pb(max(suffix[j], height[i]));
        reverse(suffix.begin(), suffix.end());

        int ans = 0;
        for(int i = 0; i < n; i++) ans += min(prefix[i], suffix[i]) - height[i];
        

        return ans;
    }
};