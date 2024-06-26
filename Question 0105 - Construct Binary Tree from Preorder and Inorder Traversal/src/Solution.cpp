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
    int findPosition(vector<int> &inorder, int element, int n)
    {
        for (int i = 0; i < n; i++)
        {
            if (inorder[i] == element)
                return i;
        }

        return -1;
    }

    TreeNode *solve(vector<int> &preorder, vector<int> &inorder, int &index, int inOrderStart, int inOrderEnd, int n)
    {
        // base case
        if (index >= n || inOrderStart > inOrderEnd)
            return NULL;

        int element = preorder[index++];
        TreeNode *root = new TreeNode(element);
        int position = findPosition(inorder, element, n);
        root->left = solve(preorder, inorder, index, inOrderStart, position - 1, n);
        root->right = solve(preorder, inorder, index, position + 1, inOrderEnd, n);

        return root;
    }

public:
    TreeNode *buildTree(vector<int> &preorder, vector<int> &inorder)
    {
        int n = inorder.size();
        int index = 0;
        return solve(preorder, inorder, index, 0, n - 1, n);
    }
};