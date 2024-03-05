public class Trie
{
    TrieNode root;
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

        int index = word.charAt(0) - 'a';
        TrieNode child;


        //present
        if(root.children[index] != null) child = root.children[index];
        else
        {
            //absent
            child = new TrieNode(word.charAt(0));
            root.children[index] = child;
        }

        insertUtil(child,word.substring(1));
    }
    public void insert(String word)
    {
        insertUtil(root,word);
    }

    private boolean searchUtil(TrieNode root, String word)
    {
        if(word.isEmpty()) return root.isTerminal;

        int index = word.charAt(0) - 'a';
        TrieNode child;

        if(root.children[index] != null) child = root.children[index];
        else return false;

        return searchUtil(child,word.substring(1));
    }
    public boolean search(String word)
    {
        return searchUtil(root,word);
    }
}
