import java.util.ArrayList;
import java.util.List;

class Trie
{
    private final TrieNode root;

    Trie()
    {
        root = new TrieNode(-1);
    }

    private int[] getDigits(int num)
    {
        String number = String.valueOf(num);
        int[] digits = new int[number.length()];

        for (int i = 0; i < number.length(); i++) {
            digits[i] = Character.getNumericValue(number.charAt(i));
        }

        return digits;
    }

    private void insertUtil(TrieNode root,int[] digits, int index)
    {
        if(index == digits.length)
        {
            root.isTerminal = true;
            return;
        }

        int digit = digits[index];
        if(root.children[digit] == null)
            root.children[digit] = new TrieNode(digit);

        insertUtil(root.children[digit], digits, index+1);
    }

    public void insert(int num)
    {
        int[] digits = getDigits(num);
        insertUtil(root, digits, 0);
    }

    private void sortUtil(TrieNode root, List<Integer> ans, int num)
    {
        if(root == null) return;
        if(root.isTerminal) ans.add(num);

        for (int i = 0; i < 10; i++) {
            if(root.children[i] != null)
                sortUtil(root.children[i], ans, (num*10)+i);
        }
    }

    public List<Integer> sort()
    {
        List<Integer> ans = new ArrayList<>();
        sortUtil(root,ans,0);
        return ans;
    }

}
