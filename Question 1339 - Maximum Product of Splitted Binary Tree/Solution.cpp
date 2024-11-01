#include <bits/stdc++.h>
using namespace std;

struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

int MOD = 1e9 + 7;

class Solution
{
public:
    int dfs(TreeNode *root, vector<int> &arr)
    {
        if (root == NULL)
            return 0;

        int curr = root->val + dfs(root->left, arr) + dfs(root->right, arr);
        arr.push_back(curr);
        return curr;
    }

    int maxProduct(TreeNode *root)
    {
        vector<int> sum;
        int total = dfs(root, sum);

        int maxi = 0;

        for (int i = 0; i < sum.size(); ++i){
            maxi = max(maxi, (total - sum[i]) * sum[i]);
        }

        return maxi%MOD;
    }
};