package recursion.backtracking;

public class TargetSum {

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(findTargetSumWays(nums, 1));
    }
    public static int findTargetSumWays(int[] nums, int target) {
        return allPossibleCombinations(nums, target, 0, 0);
    }

    private static int allPossibleCombinations(int[] nums, int target, int counter, int index){
        if(index==nums.length){
            if(counter==target){
                return 1;
            }
            return 0;
        }
        int ans = 0;
        ans += allPossibleCombinations(nums, target, counter+nums[index], index+1);
        ans += allPossibleCombinations(nums, target, counter-nums[index], index+1);
        return ans;
    }
}
