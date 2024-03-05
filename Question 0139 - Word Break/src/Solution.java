import java.util.List;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict)
    {
        Trie t = new Trie();
        for (int i = 0; i < wordDict.size(); i++) {
            t.insert(wordDict.get(i));
        }

        int n =s.length();
        boolean[] present = new boolean[n+1];
        present[0] = true;


        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                if(present[j] && t.search(s.substring(j,i)))
                {
                    present[i] = true;
                    break;
                }
            }
        }

        return present[n];
    }
}