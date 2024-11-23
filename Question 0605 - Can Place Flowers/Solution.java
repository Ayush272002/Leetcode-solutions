class Solution {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n > flowerbed.length) return false;
        if(n == 0) return true;
        
        if (flowerbed.length == 1) {
            return flowerbed[0] == 0 && n <= 1;
        }


        for (int i = 0; i < flowerbed.length; i++) {
            if (n == 0) return true;
            if (flowerbed[i] == 0) {
                if (i == 0 && i + 1 < flowerbed.length && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                } else if (i == flowerbed.length - 1 && i - 1 >= 0 && flowerbed[i - 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                } else if (i - 1 >= 0 && i + 1 < flowerbed.length && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }

        return n == 0;
    }
}
