class Solution {
    public int minOperations(String s) {
        char[] charS = s.toCharArray();
        int sz = charS.length;
        int[] sInt = new int[sz];
        for (int i = 0; i < sz; i++) {
            sInt[i] = Character.getNumericValue(charS[i]);
        }

        int count0101 = 0;
        int count1010 = 0;

        for (int i = 0; i < sz; i++) {
            // Check for pattern "0101..."
            if (i % 2 == sInt[0])
            {
                if (sInt[i] != 0)
                    count0101++;
            }
            else
            {
                if (sInt[i] != 1)
                    count0101++;
            }

            // Check for pattern "1010..."
            if (i % 2 == sInt[0])
            {
                if (sInt[i] != 1)
                    count1010++;
            }
            else
            {
                if (sInt[i] != 0) 
                    count1010++;
            }
        }

        // Return the minimum of the two counts
        return Math.min(count0101, count1010);
    }
}
