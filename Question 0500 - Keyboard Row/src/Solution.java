import java.util.ArrayList;
import java.util.List;

class Solution {
    private boolean isInRow(String word, String row) {
        for (char ch : word.toCharArray()) {
            if (row.indexOf(ch) == -1)
                return false;
        }

        return true;
    }

    public String[] findWords(String[] words) {
        String row1 = "qwertyuiop", row2 = "asdfghjkl", row3 = "zxcvbnm";

        List<String> st = new ArrayList<>();
        for (String word : words) {
            String word_l = word.toLowerCase();

            if (isInRow(word_l, row1) || isInRow(word_l, row2) || isInRow(word_l, row3))
                st.add(word);
        }

        return st.toArray(new String[0]);

    }
}