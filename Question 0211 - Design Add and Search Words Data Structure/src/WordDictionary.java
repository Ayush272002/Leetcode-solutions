class WordDictionary
{
    TrieNode root;

    public WordDictionary()
    {
        root = new TrieNode('\0');
    }

    private void addWordHelper(TrieNode root, String word)
    {
        if(word.isEmpty())
        {
            root.isTerminal = true;
            return;
        }

        char curr = word.charAt(0);
        if(curr == '.')
        {
            for (int i = 0; i < root.children.length; i++) {
                TrieNode child = root.children[i];
                if(child != null) addWordHelper(child, word.substring(1));
            }

        }
        else
        {
            int index = curr-'a';
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

            addWordHelper(child, word.substring(1));
        }
    }

    public void addWord(String word)
    {
        addWordHelper(root,word);
    }

    private boolean searchUtil(TrieNode root, String word)
    {
        if(word.isEmpty()) return root.isTerminal;

        char curr = word.charAt(0);
        if(curr == '.')
        {
            for (int i = 0; i < root.children.length; i++)
            {
                TrieNode child = root.children[i];
                if(child != null && searchUtil(child,word.substring(1))) return true;
            }
        }
        else
        {
            int index = curr-'a';
            TrieNode child = root.children[index];
            return child != null && searchUtil(child, word.substring(1));
        }
        return false;
    }

    public boolean search(String word)
    {
        return searchUtil(root, word);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */