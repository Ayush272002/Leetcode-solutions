import java.util.List;

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord)
    {
        Trie t = new Trie();

        for (int i = 0; i < products.length; i++) {
            String temp = products[i];
            t.insert(temp);
        }

        return t.searchSuggestions(searchWord);
    }
}