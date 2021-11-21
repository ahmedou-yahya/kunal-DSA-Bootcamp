package recursion.backtracking;

public class SudokuSolver {

    public static void main(String[] args) {
        int[][] board = new int[][]{{5,3,0,0,7,0,0,0,0},
                                    {6,0,0,1,9,5,0,0,0},
                                    {0,9,8,0,0,0,0,6,0},
                                    {8,0,0,0,6,0,0,0,3},
                                    {4,0,0,8,0,3,0,0,1},
                                    {7,0,0,0,2,0,0,0,6},
                                    {0,6,0,0,0,0,2,8,0},
                                    {0,0,0,4,1,9,0,0,5},
                                    {0,0,0,0,8,0,0,7,9}};

        int[][] board2 = new int[][]{{1,0,5},{2,9,0},{0,4,7}};

//        System.out.println(isSave(board,1,1,7));
//        display(board);
        sudokuSolver(board, 0,0);
    }

    static boolean sudokuSolver(int[][] board, int row, int col) {
        if (row == board.length) {
            display(board);
            return true;
        }
        if (col == board.length) {
            return sudokuSolver(board,row+1,  0);
        }
        if (board[row][col] == 0) {
            for (int c = 1; c <= 9; c++) {
                if (isSave(board, row, col, c)) {
                    board[row][col] = c;
                    if (sudokuSolver(board, row, col+1)) {
                        return true;
                    }
                    board[row][col] = 0;

                }
            }
        } else {
            return sudokuSolver(board, row,col+1);
        }
        return false;
    }

    private static boolean isSave(int[][] board, int row, int col, int num) {

        int j=0, k=0;
        while (j< board.length){
            if(num==board[j][col]){
                return false;
            }
            j++;
        }

        while (k< board.length){
            if(num==board[row][k]){
                return false;
            }
            k++;
        }

        int rowBox = row - row%3;
        int colBox = col - col%3;
        for (int i = rowBox; i <rowBox+3; i++) {
            for (int l = colBox; l < colBox+3; l++) {
                if (board[i][l]==num)
                    return false;
            }
        }

        return true;
    }

    private static void display(int[][] board) {
        for (int[] b : board) {
            String str = "";
            for (int i: b)
                str += i+" ";

            System.out.println(str);
        }
    }
}
