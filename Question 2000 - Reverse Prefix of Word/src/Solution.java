class Solution
{
    public String reversePrefix(String word, char ch)
    {
        int pos = word.indexOf(ch);
        if(pos == -1) return word;

        char[] arr = word.toCharArray();
        int start = 0;
        while(start <= pos)
        {
            char temp = arr[start];
            arr[start] = arr[pos];
            arr[pos] = temp;
            start++;
            pos--;
        }

        return new String(arr);
    }
}