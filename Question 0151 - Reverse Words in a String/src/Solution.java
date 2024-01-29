class Solution {
    public String reverseWords(String s)
    {
        s = s.trim();
        String[] arr = s.split("\\s+");

        int start = 0, end = arr.length-1;

        while(start <= end)
        {
            String temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            sb.append(" ");
        }

        return sb.toString().trim();
    }
}