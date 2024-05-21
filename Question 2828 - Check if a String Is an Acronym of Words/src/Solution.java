import java.util.List;

class Solution
{
    public boolean isAcronym(List<String> words, String s)
    {
        if(s.length() != words.size() || s.charAt(0) != words.get(0).charAt(0)) return false;

        for(int i = 1; i < s.length(); i++)
        {
            if(s.charAt(i) != words.get(i).charAt(0)) return false;
        }

        return true;
    }
}