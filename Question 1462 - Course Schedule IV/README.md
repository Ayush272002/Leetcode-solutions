# [1462. Course Schedule IV](https://leetcode.com/problems/course-schedule-iv/description/?envType=problem-list-v2&envId=topological-sort)

There are a total of `numCourses` courses you have to take, labeled from `0` to `numCourses - 1`. You are given an array `prerequisites` where `prerequisites[i] = [a<sub>i</sub>, b<sub>i</sub>]` indicates that you **must** take course `a<sub>i</sub>` first if you want to take course `b<sub>i</sub>`.

- For example, the pair `[0, 1]` indicates that you have to take course `0` before you can take course `1`.

Prerequisites can also be **indirect** . If course `a` is a prerequisite of course `b`, and course `b` is a prerequisite of course `c`, then course `a` is a prerequisite of course `c`.

You are also given an array `queries` where `queries[j] = [u<sub>j</sub>, v<sub>j</sub>]`. For the `j^th` query, you should answer whether course `u<sub>j</sub>` is a prerequisite of course `v<sub>j</sub>` or not.

Return <i>a boolean array </i>`answer`<i>, where </i>`answer[j]`<i> is the answer to the </i>`j^th`<i> query.</i>

**Example 1:**

<img alt="" src="https://assets.leetcode.com/uploads/2021/05/01/courses4-1-graph.jpg" style="width: 222px; height: 62px;">

```
Input: numCourses = 2, prerequisites = [[1,0]], queries = [[0,1],[1,0]]
Output: [false,true]
Explanation: The pair [1, 0] indicates that you have to take course 1 before you can take course 0.
Course 0 is not a prerequisite of course 1, but the opposite is true.
```

**Example 2:**

```
Input: numCourses = 2, prerequisites = [], queries = [[1,0],[0,1]]
Output: [false,false]
Explanation: There are no prerequisites, and each course is independent.
```

**Example 3:**

<img alt="" src="https://assets.leetcode.com/uploads/2021/05/01/courses4-3-graph.jpg" style="width: 222px; height: 222px;">

```
Input: numCourses = 3, prerequisites = [[1,2],[1,0],[2,0]], queries = [[1,0],[1,2]]
Output: [true,true]
```

**Constraints:**

- `2 <= numCourses <= 100`
- `0 <= prerequisites.length <= (numCourses * (numCourses - 1) / 2)`
- `prerequisites[i].length == 2`
- `0 <= a<sub>i</sub>, b<sub>i</sub> <= numCourses - 1`
- `a<sub>i</sub> != b<sub>i</sub>`
- All the pairs `[a<sub>i</sub>, b<sub>i</sub>]` are **unique** .
- The prerequisites graph has no cycles.
- `1 <= queries.length <= 10^4`
- `0 <= u<sub>i</sub>, v<sub>i</sub> <= numCourses - 1`
- `u<sub>i</sub> != v<sub>i</sub>`
