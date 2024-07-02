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

class Solution
{
private:
    TreeNode *solve(vector<int> &inorder, int is, int ie, vector<int> &postorder, int ps, int pe, map<int, int> &map)
    {
        if (ps > pe || is > ie)
            return NULL;

        TreeNode *root = new TreeNode(postorder[pe]);

        int val = map[postorder[pe]];
        root->left = solve(inorder, is, val - 1, postorder, ps, ps + val - is - 1, map);
        root->right = solve(inorder, val + 1, ie, postorder, ps + val - is, pe - 1, map);

        return root;
    }

public:
    TreeNode *buildTree(vector<int> &inorder, vector<int> &postorder)
    {
        int n = inorder.size();
        map<int, int> map;
        for (int i = 0; i < n; i++)
        {
            map[inorder[i]] = i;
        }

        return solve(inorder, 0, n - 1, postorder, 0, n - 1, map);
    }
};