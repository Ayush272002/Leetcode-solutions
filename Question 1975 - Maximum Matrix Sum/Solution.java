class Solution {

    public long maxMatrixSum(int[][] matrix) {
        int neg = 0;
        long mini = Long.MAX_VALUE;
        int n = matrix.length, m = matrix[0].length;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] < 0)
                    neg++;
                mini = Math.min(mini, Math.abs(matrix[i][j]));
                sum += Math.abs(matrix[i][j]);
            }
        }

        return neg % 2 == 0 ? sum : sum - 2 * mini;
    }
}
