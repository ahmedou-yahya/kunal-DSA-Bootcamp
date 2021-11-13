package recursion.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Nqueens {

    public static void main(String[] args) {

        boolean[][] board = new boolean[4][4];

        possibleplaces(board, 0);

    }

    public static void possibleplaces(boolean[][] board, int row){
        int n = board.length;
        int m = board[0].length;

        if(row == board.length){
            display(board);
            System.out.println();
        }

        for (int col = 0; col < board[0].length; col++) {

            if(isSafe(board, row, col)){
                board[row][col] = true;
                possibleplaces(board, row+1);
                board[row][col] = false;
            }
        }
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {

        for (int i = 0; i < row; i++) {
            if(board[i][col])
                return false;
        }

        int maxLeft = Math.min(row, col);
        for (int i = 0; i <= maxLeft; i++) {
            if (board[row-i][col-i])
                return false;
        }

        int maxRight = Math.min(row, board.length-col-1);
        for (int i = 0; i <=maxRight; i++) {
            if(board[row-i][col+i])
                return false;
        }

        return true;
    }

    private static void display(boolean[][] board) {
        for(boolean[] row : board) {
            for(boolean element : row) {
                if (element) {
                    System.out.print("Q ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

}
