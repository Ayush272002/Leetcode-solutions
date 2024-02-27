import java.util.*;

class OptimisedSol
{
    private void dfs(String word, List<String> sq, String beginWord, List<List<String>> ans, Map<String, Integer> map)
    {
        if(Objects.equals(word, beginWord))
        {
            List<String> dup = new ArrayList<>(sq);
            Collections.reverse(dup);
            ans.add(dup);
            return;
        }

        //character change
        int steps = map.get(word);
        int sz = word.length();

        for (int i = 0; i < sz; i++)
        {
            for(char ch = 'a'; ch<= 'z'; ch++)
            {
                char[] arr = word.toCharArray();
                arr[i] = ch;
                String changedWord = new String(arr);
                if(map.containsKey(changedWord) && map.get(changedWord) + 1 == steps)
                {
                    sq.add(changedWord);
                    dfs(changedWord,sq,beginWord,ans, map);
                    sq.remove(sq.size()-1);
                }
            }
        }
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList)
    {
        List<List<String>> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        Set<String> set = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        map.put(beginWord,1); //level of the begin word
        set.remove(beginWord);

        int sz = beginWord.length(); // to avoid tle
        while(!q.isEmpty())
        {
            String word = q.poll();
            int steps = map.get(word);

            if(Objects.equals(word, endWord)) break;

            for (int i = 0; i < sz; i++)
            {
                for(char ch = 'a'; ch<= 'z'; ch++)
                {
                    char[] arr = word.toCharArray();
                    arr[i] = ch;
                    String changedWord = new String(arr);
                    if(set.contains(changedWord))
                    {
                        q.add(changedWord);
                        set.remove(changedWord);
                        map.put(changedWord,steps+1);
                    }
                }
            }
        }

        if(map.containsKey(endWord))
        {
            List<String> sq = new ArrayList<>();
            sq.add(endWord);
            dfs(endWord, sq, beginWord, ans,map);
        }

        return ans;
    }
}