class Solution
{
    public boolean isValid(String word)
    {
        word = word.toLowerCase();

        boolean vow = false, conso = false;
        int count = 0;
        if(word.length() < 3) return false;

        for(char ch : word.toCharArray())
        {
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            {
                vow = true;
                count++;
            }
            else if(ch >= 'a' && ch <= 'z')
            {
                conso = true;
                count++;
            }
            else if(Character.isDigit(ch)) count++;
            else return false;
        }

        return vow && conso && count >= 3;
    }
}