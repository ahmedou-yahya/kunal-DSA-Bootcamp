package recursion.backtracking;

public class MaxProdSubarray {

    public static void main(String[] args) {

    }

    public static int maxProduct(int[] nums) {
        if(nums.length==1)
            return nums[0];

        int min = nums[0], max = min, ans = max;

        for (int i=1; i<nums.length; i++){

            int temp = max;

            max = Math.max(Math.max(max*nums[i], min*nums[i]), nums[i]);
            min = Math.min(Math.min(temp*nums[i], min*nums[i]), nums[i]);

            if (max>ans)
                ans = max;
        }
        return ans;
    }
}
