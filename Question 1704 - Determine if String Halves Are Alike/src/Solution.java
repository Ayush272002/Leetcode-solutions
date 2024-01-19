class Solution {
    public boolean halvesAreAlike(String s) {
        int low = 0, high = s.length()-1;
        int count = 0;
        s = s.toLowerCase();
        while(low < high)
        {
            if(s.charAt(low) == 'a' || s.charAt(low) == 'e' ||s.charAt(low) == 'i' ||s.charAt(low) == 'o' ||s.charAt(low) == 'u')
                count++;

            if(s.charAt(high) == 'a' || s.charAt(high) == 'e' ||s.charAt(high) == 'i' ||s.charAt(high) == 'o' ||s.charAt(high) == 'u')
                count--;

            low++;
            high--;
        }

        return count==0;
    }
}