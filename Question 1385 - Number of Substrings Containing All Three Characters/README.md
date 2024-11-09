# [1358. Number of Substrings Containing All Three Characters](https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/)

Given a string `s`consisting only of characters a, b and c.

Return the number of substrings containing <b>at least</b>one occurrence of all these characters a, b and c.

**Example 1:** 

```
Input: s = "abcabc"
Output: 10
Explanation: The substrings containingat leastone occurrence of the charactersa,bandc are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (**again** ). 
```

**Example 2:** 

```
Input: s = "aaacb"
Output: 3
Explanation: The substrings containingat leastone occurrence of the charactersa,bandc are "aaacb", "aacb" and "acb". 
```

**Example 3:** 

```
Input: s = "abc"
Output: 1
```

**Constraints:** 

- `3 <= s.length <= 5 x 10^4`
- `s`only consists ofa, b or ccharacters.