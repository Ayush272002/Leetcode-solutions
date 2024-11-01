# [145. Binary Tree Postorder Traversal](https://leetcode.com/problems/binary-tree-postorder-traversal/description/?envType=problem-list-v2&envId=stack&difficulty=EASY)

Given the `root` of abinary tree, return the postorder traversal of its nodes' values.

**Example 1:** 

<div class="example-block">
Input: root = [1,null,2,3]

Output: [3,2,1]

Explanation:

<img alt="" src="https://assets.leetcode.com/uploads/2024/08/29/screenshot-2024-08-29-202743.png" style="width: 200px; height: 264px;">

**Example 2:** 

<div class="example-block">
Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]

Output: [4,6,7,5,2,9,8,3,1]

Explanation:

<img alt="" src="https://assets.leetcode.com/uploads/2024/08/29/tree_2.png" style="width: 350px; height: 286px;">

**Example 3:** 

<div class="example-block">
Input: root = []

Output: []

**Example 4:** 

<div class="example-block">
Input: root = [1]

Output: [1]

**Constraints:** 

- The number of the nodes in the tree is in the range `[0, 100]`.
- `-100 <= Node.val <= 100`

**Follow up:**  Recursive solution is trivial, could you do it iteratively?