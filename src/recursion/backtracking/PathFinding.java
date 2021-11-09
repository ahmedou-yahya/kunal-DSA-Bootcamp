package recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PathFinding {

    public static void main(String[] args) {

        boolean[][] matrix = new boolean[][]{{true,false,true},{true,true, true},{true,false,true}};

        System.out.println(countPaths(3,3));
//        System.out.println(printAllPaths("", 3,3));
        System.out.println(printAllPathsWithObstacles(matrix, "", 0, 0));
    }

    static int countPaths(int row, int col){

        if(row == 1 || col == 1){
            return 1;
        }

        int count = 0;

        count += countPaths(row-1, col);
        count += countPaths( row, col-1);

        return count;
    }

    static List<String> printAllPaths(String processed, int row, int col){

        if(row == 1 || col == 1){
            List<String> list = new ArrayList<>();
            if(row!=1){
                int i=row;
                while(i>2){
                    processed += "D";
                    i--;
                }
            }
            if(col!=1){
                int i=col;
                while(i>2){
                    processed += "R";
                    i--;
                }
            }

            list.add(processed);
            return list;
        }

        List<String> ans = new ArrayList<>();

        ans.addAll(printAllPaths(processed+"D",row-1, col));
        ans.addAll(printAllPaths(processed+"R", row, col-1));

        return ans;
    }

    static List<String> printAllPathsWithObstacles(boolean[][] matrix, String processed, int row, int col){

        if(matrix[row][col]==false)
            return new ArrayList<>();

        if(row == matrix.length-1 && col == matrix[0].length-1){
            List<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        List<String> ans = new ArrayList<>();

        if(row< matrix.length-1)
            ans.addAll(printAllPathsWithObstacles(matrix,processed+"D",row+1, col));
        if(col<matrix[0].length-1)
            ans.addAll(printAllPathsWithObstacles(matrix,processed+"R", row, col+1));

        return ans;
    }
}
