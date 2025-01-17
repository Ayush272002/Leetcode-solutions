# [130. Surrounded Regions](https://leetcode.com/problems/surrounded-regions/description/)

You are given an `m x n` matrix `board` containing **letters** `'X'` and `'O'`, **capture regions** that are **surrounded** :

- **Connect** : A cell is connected to adjacent cells horizontally or vertically.
- **Region** : To form a region **connect every** `'O'` cell.
- **Surround** : The region is surrounded with `'X'` cells if you can **connect the region ** with `'X'` cells and none of the region cells are on the edge of the `board`.

A **surrounded region is captured** by replacing all `'O'`s with `'X'`s in the input matrix `board`.

**Example 1:**

<div class="example-block">
Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]

Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]

Explanation:

<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/xogrid.jpg" style="width: 367px; height: 158px;">

In the above diagram, the bottom region is not captured because it is on the edge of the board and cannot be surrounded.

**Example 2:**

<div class="example-block">
Input: board = [["X"]]

Output: [["X"]]

**Constraints:**

- `m == board.length`
- `n == board[i].length`
- `1 <= m, n <= 200`
- `board[i][j]` is `'X'` or `'O'`.
