class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        permute(res, nums, 0, nums.length-1);
        return res;
    }
    
    public void permute(List<List<Integer>> res, int[] n, int l, int r){
        if(l==r){
            List<Integer> ans = new ArrayList<Integer>();
            for(int i=0;i<n.length;i++) ans.add(n[i]);
            if(!res.contains(ans)) res.add(ans);
        }
        else{
            for(int i=l;i<=r;i++){
                n = swap(n,l,i);
                permute(res,n,l+1,r);
                n = swap(n,l,i);
                if(i>0 && n[i] == n[i-1]) continue;
            }
            
        }
    }
    
    public int[] swap(int[] n, int a, int b){
        int temp = n[a];
        n[a] = n[b];
        n[b] = temp;
        return n;
    }
}

//Method 2 implementation

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<Integer>();
        boolean[] used = new boolean[nums.length];
        permute(res,used,list,nums);
        return res;
    }
    
    public void permute(List<List<Integer>> res, boolean[] used, List<Integer> list, int[] n){
        if(n.length == list.size()){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=0;i<n.length;i++){
            if(used[i]) continue;
            if(i>0 && n[i] == n[i-1] && !used[i-1]) continue;
            used[i] = true;
            list.add(n[i]);
            permute(res,used,list,n);
            used[i] = false;
            list.remove(list.size()-1);
        }
    }
}