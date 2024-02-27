import java.util.*;

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList)
    {
        Set<String> set = new HashSet<>(wordList);

        Queue<List<String>> q = new LinkedList<>();
        ArrayList<String> first = new ArrayList<>();
        first.add(beginWord);
        q.add(first);

        ArrayList<String> usedOnLev = new ArrayList<>();
        usedOnLev.add(beginWord);
        int level = 0;

        List<List<String>> ans = new ArrayList<>();

        while(!q.isEmpty())
        {
            List<String> temp = q.poll();

            if(temp.size() > level)
            {
                level++;

                //remove all the words that have been used in the previous level
                for(String word : usedOnLev) set.remove(word);
                usedOnLev.clear();
            }

            String word = temp.get(temp.size()-1);

            if(word.equals(endWord))
            {
                if(ans.isEmpty()) ans.add(temp);
                else if(ans.get(0).size() == temp.size()) ans.add(temp);
            }
            for (int i = 0; i < word.length(); i++)
            {
                for(char ch = 'a'; ch <= 'z'; ch++)
                {
                    char[] arr = word.toCharArray();
                    arr[i] = ch;
                    String modifiedWord = new String(arr);

                    if(set.contains(modifiedWord))
                    {
                        temp.add(modifiedWord);
                        q.add(new ArrayList<>(temp));
                        usedOnLev.add(modifiedWord);
                        temp.remove(temp.size()-1);
                    }
                }
            }
        }

        return ans;
    }
}