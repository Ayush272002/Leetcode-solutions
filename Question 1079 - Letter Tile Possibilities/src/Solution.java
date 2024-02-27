import java.util.*;

class Solution {
    private void solve(String tiles, StringBuilder word, Set<String> set, boolean[] visited)
    {
        set.add(word.toString());
        for (int i = 0; i < tiles.length(); i++)
        {
            if(!visited[i])
            {
                word.append(tiles.charAt(i));
                visited[i] = true;
                solve(tiles,word,set,visited);
                visited[i] = false;
                word.deleteCharAt(word.length()-1);
            }
        }
    }

    public int numTilePossibilities(String tiles)
    {
        Set<String> set = new HashSet<>();
        StringBuilder word = new StringBuilder();
        boolean[] visited = new boolean[tiles.length()];

        solve(tiles,word,set,visited);

        return set.size()-1;
    }
}