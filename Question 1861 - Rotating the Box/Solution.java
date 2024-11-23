class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int n = box.length, m = box[0].length;
        char[][] rotatedBox = new char[m][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rotatedBox[j][n - 1 - i] = box[i][j];
            }
        }

        for (int col = 0; col < n; col++) {
            int emptyPos = m - 1;
            for (int row = m - 1; row >= 0; row--) {
                if (rotatedBox[row][col] == '#') {
                    rotatedBox[emptyPos][col] = '#';
                    if (emptyPos != row)
                        rotatedBox[row][col] = '.';

                    emptyPos--;
                } else if (rotatedBox[row][col] == '*') {
                    emptyPos = row - 1;
                }
            }
        }
        return rotatedBox;
    }
}