# [1267. Count Servers that Communicate](https://leetcode.com/problems/count-servers-that-communicate/description/?envType=daily-question&envId=2025-01-23)

You are given a map of a server center, represented as a `m * n` integer matrix`grid`, where 1 means that on that cell there is a server and 0 means that it is no server. Two servers are said to communicate if they are on the same row or on the same column.<br>
<br>
Return the number of serversthat communicate with any other server.

**Example 1:**

<img alt="" src="https://assets.leetcode.com/uploads/2019/11/14/untitled-diagram-6.jpg" style="width: 202px; height: 203px;">

```
Input: grid = [[1,0],[0,1]]
Output: 0
<b>Explanation:</b>No servers can communicate with others.
```

**Example 2:**

**<img alt="" src="https://assets.leetcode.com/uploads/2019/11/13/untitled-diagram-4.jpg" style="width: 203px; height: 203px;">**

```

Input: grid = [[1,0],[1,1]]
Output: 3
<b>Explanation:</b>All three servers can communicate with at least one other server.
```

**Example 3:**

<img alt="" src="https://assets.leetcode.com/uploads/2019/11/14/untitled-diagram-1-3.jpg" style="width: 443px; height: 443px;">

```

Input: grid = [[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]]
Output: 4
<b>Explanation:</b>The two servers in the first row can communicate with each other. The two servers in the third column can communicate with each other. The server at right bottom corner can't communicate with any other server.

```

**Constraints:**

- `m == grid.length`
- `n == grid[i].length`
- `1 <= m <= 250`
- `1 <= n <= 250`
- `grid[i][j] == 0 or 1`
