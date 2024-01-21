class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0, column = matrix[0].length -1;


        while(row < matrix.length && column >= 0)
        {
            if(matrix[row][column] == target) return true;
            if(matrix[row][column] > target) column--;
            else if(matrix[row][column] < target) row++;
        }
        return false;
    }
}


//Time complexity - O(rows+columns)