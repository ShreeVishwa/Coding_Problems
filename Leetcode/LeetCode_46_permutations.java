class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permute(res,nums,0,nums.length-1);
        return res;
    }
    
    public void permute(List<List<Integer>> res, int[] n, int l, int r){
        if(l==r){
            List<Integer> ans = new ArrayList<Integer>();
            for(int i=0;i<n.length;i++) ans.add(n[i]);
            res.add(ans);
        }
        else{
            for(int i=l;i<=r;i++){
                n = swap(n,l,i);
                permute(res,n,l+1,r);
                n = swap(n,l,i);
            }
        }
    }
    
    public int[] swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
        return nums;
    }
}