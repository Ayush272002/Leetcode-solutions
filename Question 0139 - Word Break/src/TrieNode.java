public class TrieNode
{
    char data;
    boolean isTerminal;
    TrieNode[] children;

    TrieNode(char ch)
    {
        this.data = ch;
        isTerminal = false;
        children = new TrieNode[26];

        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
    }
}
