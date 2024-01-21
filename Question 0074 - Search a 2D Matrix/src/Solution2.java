class Solution2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if (rows == 0) {
            return false;
        }

        int columns = matrix[0].length;
        int left = 0, right = rows * columns - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; //overcome overflow 
            int midValue = matrix[mid / columns][mid % columns];

            if (midValue == target) return true;
            else if (midValue < target) left = mid + 1;
            else right = mid - 1;
        }

        return false;
    }
}


//Time complexity - O(log(m*n))