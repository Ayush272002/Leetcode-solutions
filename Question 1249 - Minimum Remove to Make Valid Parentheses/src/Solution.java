class Solution
{
    public String minRemoveToMakeValid(String s)
    {
        char[] arr = s.toCharArray();

        int open = 0;
        int n = arr.length;

        for(int i = 0; i < n; i++)
        {
            if(arr[i] == '(') open++;
            else if (arr[i] == ')' && open == 0) arr[i] = '#';
            else if(arr[i] == ')') open--;
        }

        for(int i = n-1; i >= 0 && open > 0; i--)
        {
            if(arr[i] == '(')
            {
                arr[i] = '#';
                open--;
            }
        }

        StringBuilder res = new StringBuilder();
        for(int i = 0; i < n; i++)
        {
            if(arr[i] != '#') res.append(arr[i]);
        }

        return res.toString();
    }
}