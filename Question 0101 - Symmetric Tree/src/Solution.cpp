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
    bool solve(TreeNode *t1, TreeNode *t2)
    {
        if(!t1 && !t2)
            return true;

        if((!t1 && t2) || (t1 && !t2))
            return false;

        return solve(t1->left, t2->right) && solve(t1->right, t2->left) && t1->val == t2->val;
    }

public:
    bool isSymmetric(TreeNode *root)
    {
        return solve(root->left, root->right);
    }
};