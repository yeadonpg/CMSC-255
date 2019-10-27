package Lab_9;

public class Lab9 {

    public static void main(String[] args) {

        int [][] matrix = {
                {-1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, -1, 0, -1},
                {0, 0, 0, -1, 0, 0},
                {0, 0, 0, 0, 0, 0}
        };

        int [][] matrix2 = {
                {6, 3, 2, 0, 4},
                {34, 53, 0, 23, 1},
                {0, 23, 54, 11, 7}
        };

        int [][] matrix3 = {
                { 0, -1, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0 },
                { -1, 0, 0, 0, 0, 0 },
                { -1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0 }
        };

        addTo10(matrix2);
        setHints(matrix);
        setHints(matrix3);
    }

    static void addTo10(int[][] array) {

        for (int i = 0; i < array.length; i++) {
            int rowLen = array[i].length;
            int sumRow = 0;

            int zeroIndex = 0;
            int currentNum;

            for (int j = 0; j < rowLen; j++) {
                sumRow += array[i][j];

                currentNum = array[i][j];
                if (currentNum == 0) {
                    zeroIndex = j;
                }
            }

            int leftOver = 10 - sumRow;

            array[i][zeroIndex] = leftOver;
        }
    }

    static void setHints(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (isBomb(array[i][j])) {
                    for (int k = -1; k < 2; k++) {
                        for (int l = -1; l < 2; l++) {
                            if (isInBounds(i + k, j + l, array)) {
                                int curSpace = array[i + k][j + l];
                                if (!isBomb(curSpace)) {
                                    array[i + k][j + l] += 1;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static boolean isInBounds(int i, int j, int[][] board){
        return (i >= 0 && i < board.length) && (j >= 0 && j < board[i].length);
    }

    private static boolean isBomb(int value){
        return value == -1;
    }
}
