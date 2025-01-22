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
    TreeNode *minVal(TreeNode *root)
    {
        TreeNode *tmp = root;
        while (tmp->left)
            tmp = tmp->left;

        return tmp;
    }

public:
    TreeNode *deleteNode(TreeNode *root, int key)
    {
        if (!root)
            return root;

        if (root->val == key)
        {

            // 0 child
            if (!root->left && !root->right)
            {
                root = NULL;
                return NULL;
            }

            // 1 child
            if (root->left && !root->right)
            {
                TreeNode *tmp = root->left;
                root = NULL;
                return tmp;
            }

            if (!root->left && root->right)
            {
                TreeNode *tmp = root->right;
                root = NULL;
                return tmp;
            }

            // 2 children
            if (root->left && root->right)
            {
                int mini = minVal(root->right)->val;

                root->val = mini;
                root->right = deleteNode(root->right, mini);
                return root;
            }
        }
        else if (root->val > key)
        {
            root->left = deleteNode(root->left, key);
            return root;
        }
        else
        {
            root->right = deleteNode(root->right, key);
            return root;
        }
    }
};