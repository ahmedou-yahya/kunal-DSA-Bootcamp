package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RecursionSubsequence {

    public static void main(String[] args) {
//        printAllSubsequences("", "abc");
//        printAllPermutations("", "abc");
//        List<String> list = allPossibleCombinations("","23");
//        for(String s: list){
//            System.out.println(s);
//        }
        System.out.println(numRollsToTarget("",30, 30, 500));

//        ArrayList<String> permutations = allPermutations("", "abc");
//        for( String str: permutations){
//            System.out.println(str);
//        }
//        List<List<Integer>> ans =  allPossibleSubset(new int[]{1, 2, 3});
//        for(List<Integer> list: ans){
//            System.out.println(list);
//        }
    }

    static void printAllSubsequences(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }

        char c = unprocessed.charAt(0);
        printAllSubsequences(processed+c, unprocessed.substring(1));
        printAllSubsequences(processed, unprocessed.substring(1));
    }

    // Time complexity: O(N*2^N) (number of subsets = 2^N)
    // Space Complexity: O(N*2^N) (creating an array of size n with total number of element 2^N)
    static List<List<Integer>> allPossibleSubset(int[] arr){

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i=0; i< arr.length; i++){
            int n = result.size();
            for(int j=0; j<n; j++){
                ArrayList<Integer> next = new ArrayList<Integer>(result.get(j));
                next.add(arr[i]);
                result.add(next);
            }
        }
        return result;
    }

    static void printAllPermutations(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            System.out.println(processed);
            return;
        }
        char c = unprocessed.charAt(0);

        for (int i = 0; i <= processed.length(); i++) {
            String first = processed.substring(0, i);
            String last = processed.substring(i);
            printAllPermutations(first + c + last, unprocessed.substring(1));
        }
    }
    static ArrayList<String> allPermutations(String processed, String unprocessed) {
        ArrayList<String> ans = new ArrayList<>();
        if (unprocessed.isEmpty()) {
            ans.add(processed);
            return ans;
        }
        char c = unprocessed.charAt(0);

        for (int i = 0; i <= processed.length(); i++) {
            String first = processed.substring(0, i);
            String last = processed.substring(i);
            ArrayList<String> rest = allPermutations(first + c + last, unprocessed.substring(1));
            ans.addAll(rest);
        }

        return ans;
    }

    //Leetcode: Letter Combinations of a Phone Number ( https://leetcode.com/problems/letter-combinations-of-a-phone-number/ )

    static List<String> allPossibleCombinations(String processed, String unprocessed){

        List<String> result = new ArrayList<>();

        if(unprocessed.isEmpty()){
            List<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        char digit = unprocessed.charAt(0);
        String letters = map(digit);

        for (int i=0; i<letters.length(); i++){
             char c = letters.charAt(i);
             List<String> rest = allPossibleCombinations(processed+c, unprocessed.substring(1));
             result.addAll(rest);
        }

        return result;
    }

    static String map(char c){
        HashMap<Character, String> digitToLetters = new HashMap<>();
        digitToLetters.put('2',"abc");
        digitToLetters.put('3',"def");
        digitToLetters.put('4',"ghi");
        digitToLetters.put('5',"jkl");
        digitToLetters.put('6',"mno");
        digitToLetters.put('7',"pqrs");
        digitToLetters.put('8',"tuv");
        digitToLetters.put('9',"wxyz");
        return digitToLetters.get(c);
    }

    static int numRollsToTarget(String processed, int dice, int faces, int target){

        int res = 0;
        if(target==0 && processed.length()==dice){
            return 1;
        }

        for (int i=1; i<=faces && i<=target; i++){
            int rest = numRollsToTarget(processed+i, dice, faces, target-i);
            res += rest;
        }

        return res;
    }


}
