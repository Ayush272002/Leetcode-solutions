import java.util.*;

class Solution {
    private void solve(int[] candidates, int target, List<Integer> combi, int index, List<List<Integer>> results)
    {
        if (target == 0)
        {
            results.add(new ArrayList<>(combi));
            return;
        }

        for (int i = index; i < candidates.length; i++)
        {
            // Skip duplicates
            if (i > index && candidates[i] == candidates[i - 1]) continue;

            // Check if current candidate can be included
            if (candidates[i] <= target)
            {
                combi.add(candidates[i]);
                solve(candidates, target - candidates[i], combi, i + 1, results); // Pass i+1 to avoid reusing same element
                combi.removeLast(); // Backtrack
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target)
    {
        Arrays.sort(candidates);
        List<List<Integer>> results = new ArrayList<>();
        solve(candidates, target, new ArrayList<>(), 0, results);
        return results;
    }
}
