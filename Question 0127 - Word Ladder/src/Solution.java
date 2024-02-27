import java.util.*;

class Solution
{
    public int ladderLength(String beginWord, String endWord, List<String> wordList)
    {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));

        Set<String> set = new HashSet<>(wordList);
        set.remove(beginWord);

        while(!q.isEmpty())
        {
            Pair node = q.poll();
            String word = node.first;
            int steps = node.second;

            if(word.equals(endWord)) return steps;

            for (int i = 0; i < word.length(); i++) {
                for(char ch = 'a'; ch <= 'z'; ch++)
                {
                    char[] temp = word.toCharArray();
                    temp[i] = ch;
                    String replacedWord = new String(temp);


                    //check if its there in the set
                    if(set.contains(replacedWord))
                    {
                        set.remove(replacedWord);
                        q.add(new Pair(replacedWord, steps+1));
                    }
                }
            }
        }

        return 0;
    }
}