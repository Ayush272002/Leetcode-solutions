import java.util.List;

class Solution {
    public List<Integer> lexicalOrder(int n)
    {
        int[] arr = new int[n];

        int k =1;
        for (int i = 0; i < n; i++) {
            arr[i] = k++;
        }

        Trie t = new Trie();
        for (int i = 0; i < arr.length; i++) {
            t.insert(arr[i]);
        }

        return t.sort();
    }
}