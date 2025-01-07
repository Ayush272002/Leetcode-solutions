# [1254. Number of Closed Islands](https://leetcode.com/problems/number-of-closed-islands/description/)

Given a 2D`grid` consists of `0s` (land)and `1s` (water). An island is a maximal 4-directionally connected group of `0s` and a closed islandis an island **totally** (all left, top, right, bottom) surrounded by `1s.`

Return the number of closed islands.

**Example 1:** 

<img alt="" src="https://assets.leetcode.com/uploads/2019/10/31/sample_3_1610.png" style="width: 240px; height: 120px;">

```
Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
Output: 2
Explanation: 
Islands in gray are closed because they are completely surrounded by water (group of 1s).
```

**Example 2:** 

<img alt="" src="https://assets.leetcode.com/uploads/2019/10/31/sample_4_1610.png" style="width: 160px; height: 80px;">

```
Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
Output: 1
```

**Example 3:** 

```
Input: grid = [[1,1,1,1,1,1,1],
              [1,0,0,0,0,0,1],
              [1,0,1,1,1,0,1],
              [1,0,1,0,1,0,1],
              [1,0,1,1,1,0,1],
              [1,0,0,0,0,0,1],
               [1,1,1,1,1,1,1]]

Output: 2
```

**Constraints:** 

- `1 <= grid.length, grid[0].length <= 100`
- `0 <= grid[i][j] <=1`