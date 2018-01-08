class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] l = new int[n];
        int[] r = new int[n];
        l[0] = 1;
        r[n-1] = 1;
        for(int i=1;i<n;i++) l[i] = l[i-1]*nums[i-1];
        for(int i=n-2;i>=0;i--) r[i] = r[i+1]*nums[i+1];
        int[] res = new int[n];
        for(int i=0;i<n;i++) res[i] = l[i]*r[i];
        return res;
    }
}

//Another solution without extra space

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for(int i=1;i<n;i++) res[i] = res[i-1]*nums[i-1];
        int right = 1;
        for(int i=n-1;i>=0;i--){
            res[i] = res[i]*right;
            right = right*nums[i];
        }
        return res;
    }
}