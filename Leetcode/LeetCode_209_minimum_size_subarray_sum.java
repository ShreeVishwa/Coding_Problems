class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int s1 = 0;
        for(int i=0;i<nums.length;i++) s1+=nums[i];
        if(s1 < s) return 0;
        int st=0, e=0, minlen = nums.length, sum=0;
        while(e<nums.length){
            sum += nums[e];
            // System.out.println(sum);
            if(sum >= s){
                minlen = Math.min(minlen,e-st+1);
                // System.out.println(e-st);
                sum = sum - nums[st]-nums[e];
                st++;
            }
            else e++;
        }
        // if(sum < s) return 0;
        return minlen;
    }
}