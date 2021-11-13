package recursion.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PathFinding {

    public static void main(String[] args) {

        boolean[][] matrix = new boolean[][]{{true,true,true},{true,true, true},{true,true,true}};

        System.out.println(countPaths(3,3));
//        System.out.println(printAllPaths("", 3,3));
//        System.out.println(printAllPathsWithObstacles(matrix, "", 0, 0));
//        allPathsFourDirections(matrix,"", 0,0);
        printAllPaths(matrix, "",0, 0, new int[matrix.length][matrix[0].length], 1);
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

    static void allPathsFourDirections(boolean[][] matrix, String processed, int row, int col){

        if(row == matrix.length-1 && col == matrix[0].length-1){
            System.out.println(processed);
            return;
        }

        if(!matrix[row][col])
            return;

        matrix[row][col]=false;

        if(row< matrix.length-1)
            allPathsFourDirections(matrix,processed+"D",row+1, col);
        if(col<matrix[0].length-1)
            allPathsFourDirections(matrix,processed+"R", row, col+1);
        if(row>0){
            allPathsFourDirections(matrix,processed+"U", row-1, col);
        }
        if(col>0){
            allPathsFourDirections(matrix,processed+"L", row, col-1);
        }

        matrix[row][col]=true;
    }

    // I need to come back to this later on:
    static void printAllPaths(boolean[][] matrix, String processed, int row, int col, int[][] path, int step){

        if(row == matrix.length-1 && col == matrix[0].length-1){
            path[row][col] = step;
            System.out.println(processed);
            for (int[] arr: path){
                System.out.println(Arrays.toString(arr));
            }
            return;
        }

        if(!matrix[row][col])
            return;

        matrix[row][col]=false;
        path[row][col] = step;

        if(row< matrix.length-1)
            printAllPaths(matrix, processed, row+1, col, path, step+1);
        if(col<matrix[0].length-1)
            printAllPaths(matrix, processed, row, col+1, path, step+1);
        if(row>0){
            printAllPaths(matrix, processed, row-1, col, path, step+1);
        }
        if(col>0){
            printAllPaths(matrix, processed, row, col-1, path, step+1);
        }

        path[row][col] = 0;
        matrix[row][col]=true;
    }
}
