import java.util.ArrayList;
import java.util.List;

class Trie
{
    private final TrieNode root;

    Trie()
    {
        root = new TrieNode('\0');
    }

    private void insertUtil(TrieNode root, String word)
    {
        if(word.isEmpty())
        {
            root.isTerminal = true;
            return;
        }

        int index = word.charAt(0)-'a';
        TrieNode child;

        if(root.children[index] != null)
        {
            child = root.children[index];
        }
        else
        {
            child = new TrieNode(word.charAt(0));
            root.children[index] = child;
        }

        insertUtil(child,word.substring(1));
    }

    public void insert(String word)
    {
        insertUtil(root, word);
    }

    private void suggest(TrieNode curr, ArrayList<String> temp, StringBuilder prefix)
    {
        if (temp.size() == 3) return;
        if(curr.isTerminal) temp.add(prefix.toString());

        for (char ch = 'a'; ch <= 'z' ; ch++) {
            if (temp.size() == 3) return;
            TrieNode next = curr.children[ch-'a'];

            if(next != null)
            {
                prefix.append(ch);
                suggest(next, temp, prefix);

                prefix.deleteCharAt(prefix.length()-1);
            }
        }
    }

    public List<List<String>> searchSuggestions(String word)
    {
        TrieNode prev = root;
        List<List<String>> ans = new ArrayList<>();
        StringBuilder prefix = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char lastCh = word.charAt(i);

            prefix.append(lastCh);

            TrieNode curr = prev.children[lastCh-'a'];

            if(curr == null) break;

            ArrayList<String> temp = new ArrayList<>();
            suggest(curr, temp, prefix);

            ans.add(temp);
            prev = curr;
        }

        // Pad the result with empty lists for the remaining characters
        while (ans.size() < word.length()) {
            ans.add(new ArrayList<>());
        }

        return ans;
    }
}
