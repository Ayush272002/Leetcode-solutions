public class Trie
{
    TrieNode root;
    Trie()
    {
        root = new TrieNode('\0');
    }

    private void insertUtil(TrieNode root, String word)
    {
        //base case
        if(word.isEmpty())
        {
            root.isTerminal = true;
            return;
        }

        //word in small case
        int index = word.charAt(0) - 'a';
        TrieNode child;

        //present
        if(root.children[index] != null)
        {
            child = root.children[index];
        }
        else
        {
            //absent
            child = new TrieNode(word.charAt(0));
            root.children[index] = child;
        }

        //recursion
        insertUtil(child, word.substring(1));
    }

    public void insertWord(String word)
    {
        insertUtil(root, word);
    }

    private boolean searchUtil(TrieNode root, String word)
    {
        //base case
        if(word.isEmpty())
        {
            return root.isTerminal;
        }

        int index = word.charAt(0) - 'a';
        TrieNode child;

        //present
        if(root.children[index] != null) child = root.children[index];
        else return false;

        //recursion
        return searchUtil(child, word.substring(1));
    }

    public boolean search(String word)
    {
        return searchUtil(root, word);
    }
}
