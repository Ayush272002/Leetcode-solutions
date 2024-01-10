class Solution {
    public int[][] flipAndInvertImage(int[][] image) {

        //flipping
        for (int i = 0; i < image.length; i++) {
            int start = 0;
            int end = image[i].length -1;

            while(start < end)
            {
                // Swap elements at start and end indices
                int temp = image[i][start];
                image[i][start] = image[i][end];
                image[i][end] = temp;

                // Move indices towards each other
                start++;
                end--;
            }
        }

        //inverting
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                if(image[i][j] == 0) image[i][j] =1;
                else image[i][j] = 0;
            }
        }
        return image;
    }
}