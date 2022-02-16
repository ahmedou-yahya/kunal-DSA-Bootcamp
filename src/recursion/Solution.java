package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
//        int[] nums = new int[]{5,1,6};
//        System.out.println(subsetXORSum(nums));
    }
    public static int subsetXORSum(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();

        return subsetXORSum(list, nums, 0);
    }

    private static int subsetXORSum(ArrayList<Integer> list, int[] nums, int i) {

        if(i==nums.length){
            return xor(list);
        }

        int sum = 0;

        sum += subsetXORSum(list, nums, i+1);
        list.add(nums[i]);
        sum += subsetXORSum(list, nums, i+1);

        return sum;
    }

    private static int xor(ArrayList<Integer> list){
        int sum=0;

        for(int l: list){
            sum = sum ^ l;
        }

        return sum;
    }

}