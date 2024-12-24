class Solution {
    public int hammingDistance(int x, int y) {
        int hammingD = 0;
        int xor = x ^ y;
        while (xor > 0) {
            hammingD += (xor & 1);
            xor >>= 1;
        }

        return hammingD;
    }
}