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

class BSTIterator
{
private:
    vector<int> list;
    int ptr;

    void inorder(TreeNode *root)
    {
        if (!root)
            return;

        inorder(root->left);
        list.push_back(root->val);
        inorder(root->right);
    }

public:
    BSTIterator(TreeNode *root)
    {
        inorder(root);
        if (list.size() != 0)
            ptr = 0;
    }

    int next()
    {
        return list[ptr++];
    }

    bool hasNext()
    {
        return ptr < list.size();
    }
};

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator* obj = new BSTIterator(root);
 * int param_1 = obj->next();
 * bool param_2 = obj->hasNext();
 */