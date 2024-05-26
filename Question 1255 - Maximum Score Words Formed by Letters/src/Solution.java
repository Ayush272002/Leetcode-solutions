import java.util.HashMap;
import java.util.Map;

class Solution
{
    private boolean Valid(String word, Map<Character, Integer> letterMap)
    {
        Map<Character, Integer> wordMap = new HashMap<>();
        for(char ch : word.toCharArray())
        {
            wordMap.put(ch, wordMap.getOrDefault(ch, 0)+1);
            if(wordMap.get(ch) > letterMap.getOrDefault(ch, 0)) return false;
        }
        return true;
    }

    private void solve(int i, String[] words, int[] score, Map<Character, Integer> letterMap, int curr)
    {
        //base case
        if(i >= words.length)
        {
            maxScore = Math.max(maxScore, curr);
            return;
        }

        if(Valid(words[i], letterMap))
        {
            Map<Character, Integer> newLetterMap = new HashMap<>(letterMap);
            int wordScore = 0;
            for(char ch : words[i].toCharArray())
            {
                newLetterMap.put(ch, newLetterMap.get(ch)-1);
                wordScore += score[ch-'a'];
            }

            solve(i+1, words, score, newLetterMap, curr + wordScore);
        }

        solve(i+1, words, score, letterMap, curr);
    }

    int maxScore;
    public int maxScoreWords(String[] words, char[] letters, int[] score)
    {
        maxScore = 0;
        Map<Character, Integer> letterMap = new HashMap<>();

        for(char ch : letters) letterMap.put(ch, letterMap.getOrDefault(ch, 0)+1);
        solve(0, words, score, letterMap, 0);
        return maxScore;
    }
}