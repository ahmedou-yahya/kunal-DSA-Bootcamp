package recursion.backtracking;

public class Nknights {

    public static void main(String[] args) {

        boolean[][] board = new boolean[3][3];
        possiblePlaces(board, 0,0, 5);
    }

    public static void possiblePlaces(boolean[][] board, int row, int col, int knights){

        if(knights == 0){
            display(board);
            System.out.println();
            return;
        }

        if (row==board.length-1 && col == board.length)
            return;

        if (col == board.length){
            possiblePlaces(board,row+1, 0, knights);
            return;
        }
        if(isSave(board, row, col)) {
            board[row][col] = true;
            possiblePlaces(board, row, col+1, knights-1);
            board[row][col] = false;
        }

        possiblePlaces(board, row, col+1, knights);

    }

    private static boolean isSave(boolean[][] board, int row, int col) {

        int n = board.length;
        if( isValid(board, row-1, col-2)&& board[row-1][col-2])
            return false;

        if (isValid(board, row-1,col+2) && board[row-1][col+2])
            return false;

        if(isValid(board,row-2, col-1) && board[row-2][col-1])
            return false;

        if(isValid(board, row-2, col+1) && board[row-2][col+1]){
            return false;
        }

        return true;
    }

    private static boolean isValid(boolean[][] board, int row, int col){
        if((row>=0 && row< board.length) && (col>=0 && col< board.length))
            return true;

        return false;
    }

    private static void display(boolean[][] board) {
        for(boolean[] row : board) {
            for(boolean element : row) {
                if (element) {
                    System.out.print("K ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
