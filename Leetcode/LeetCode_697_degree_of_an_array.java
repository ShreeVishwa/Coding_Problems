class Solution {
    public int findShortestSubArray(int[] nums) {
        if(nums.length == 0) return 0;
        int[] count = new int[50000];
        int max_count = Integer.MIN_VALUE, min_val = Integer.MAX_VALUE;
        Map<Integer,Integer[]> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            count[nums[i]]++;
            if(count[nums[i]] > max_count) {
                max_count = count[nums[i]];
            }
            if(map.get(nums[i]) == null) map.put(nums[i],new Integer[2]);
            Integer[] range = map.get(nums[i]);
            if(range[0] == null) range[0] = i;
            range[1] = i;
        }
        for(int i=0;i<nums.length;i++){
            if(count[nums[i]] != max_count) continue;
            Integer[] range = map.get(nums[i]);
            min_val = Math.min(min_val,range[1] - range[0] + 1);
        }
        return min_val;
    }
}