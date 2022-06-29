package com.onejava;

public class PS005_SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix =
                {
                        {1, 2, 3, 4, 5},
                        {16, 17, 18, 19, 6},
                        {15, 24, 25, 20, 7},
                        {14, 23, 22, 21, 8},
                        {13, 12, 11, 10, 9}
                };

        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}; // 3 * 3

        int[][] matrix2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}}; // 3 * 4

        printSpiralOrder(matrix); // prints from 1 to 25 in order
        System.out.println();
        printSpiralOrder(matrix1); // 1 2 3 6 9 8 7 4 5
        System.out.println();
        printSpiralOrder(matrix2); // [1,2,3,4,8,12,11,10,9,5,6,7]

    }

    /*
    Time complexity: O(n * m) As we are accessing all the elements only once
       T↑----→R
       ;      ;
       L←----↓B

    1. Initialize pointers topRow = 0, bottomRow = row - 1, leftColumn = 0, rightColumn = col - 1
    2. 4 Loops to iterate in 4 direction --> top to right, right to bottom, bottom to left, left to top
    3. After each direction iteration, remove respective row or column (since all elements are printed in that direction)
    4. Run the loop until topRow <= bottomRow a&& leftColumn <= rightColumn

    5. To iterate row wise fix the row. When iterating column wise fix the column. Be careful when iterating from higher to lower index

     */
    private static void printSpiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        System.out.println("Row: " + row + " Col: " + col);

        int tr = 0, br = row - 1;
        int lc = 0, rc = col - 1;

        while (tr <= br && lc <= rc) {
            // top to right
            for (int i = tr; i <= rc; i++) {
                System.out.print(matrix[tr][i] + " ");
            }
            tr++; // remove top row

            // right to bottom
            for (int i = tr; i <= br; i++) {
                System.out.print(matrix[i][rc] + " ");
            }
            rc--; // remove right column

            // bottom to left
            for (int i = rc; i >= lc; i--) {
                System.out.print(matrix[br][i] + " ");
            }
            br--; // remove bottom row

            // left to top
            for (int i = br; i >= tr; i--) {
                System.out.print(matrix[i][lc] + " ");
            }
            lc++; // remove left column
        }

    }
}
