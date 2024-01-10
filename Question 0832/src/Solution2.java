class Solution2 {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;

        for (int i = 0; i < n; i++) {
            int start = 0;
            int end = n - 1;

            while (start <= end) {

                int temp = image[i][start];
                image[i][start] = image[i][end] ^ 1; // Invert while swapping
                image[i][end] = temp^1; // Invert while swapping

                // Move indices towards each other
                start++;
                end--;
            }
        }

        return image;
    }
}
