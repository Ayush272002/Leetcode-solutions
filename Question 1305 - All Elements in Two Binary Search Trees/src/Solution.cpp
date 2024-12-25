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
    void inOrder(TreeNode *root, vector<int> &list)
    {
        if (root == NULL)
            return;

        inOrder(root->left, list);
        list.push_back(root->val);
        inOrder(root->right, list);
    }

public:
    vector<int> getAllElements(TreeNode *root1, TreeNode *root2)
    {
        vector<int> l1, l2;
        inOrder(root1, l1);
        inOrder(root2, l2);

        vector<int> ans;
        int p1 = 0, p2 = 0;

        while (p1 < l1.size() && p2 < l2.size())
        {
            if (l1[p1] < l2[p2])
                ans.push_back(l1[p1++]);
            else
                ans.push_back(l2[p2++]);
        }

        while (p1 < l1.size())
        {
            ans.push_back(l1[p1++]);
        }
        while (p2 < l2.size())
        {
            ans.push_back(l2[p2++]);
        }

        return ans;
    }
};