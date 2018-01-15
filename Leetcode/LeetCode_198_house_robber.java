//Simple DP solution with O(n) Space

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0],nums[1]);
        if(nums.length == 3) return Math.max(nums[2] + nums[0], nums[1]);
        int max_ind = 0, res;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        res = Math.max(dp[0],dp[1]);
        dp[2] = nums[2] + dp[0];
        res = Math.max(res,dp[2]);
        max_ind = dp[0] > dp[1] ? 0 : 1;
        for(int i=3;i<nums.length;i++){
            dp[i] = nums[i] + dp[max_ind];
            res = Math.max(res,dp[i]);
            if(dp[i-1] > dp[max_ind]) max_ind = i-1;
        }
        return res;
    }
}

//Simple DP solution with O(1) Space

class Solution {
    public int rob(int[] nums) {
        int prev_no = 0;
	int prev_yes = 0;
	for(int i=0;i<nums.length;i++){
		int temp = prev_no;
		prev_no = Math.max(prev_no, prev_yes);
		prev_yes = nums[i] + temp;
	}
	return Math.max(prev_yes,prev_no);
    }
}