class TrieNode
{
    int data;
    TrieNode[] children;
    Boolean isTerminal;

    TrieNode(int data)
    {
        this.data = data;
        children = new TrieNode[10]; //0 to 9

        for (int i = 0; i < 10; i++) {
            children[i] = null;
        }

        isTerminal = false;
    }
}
