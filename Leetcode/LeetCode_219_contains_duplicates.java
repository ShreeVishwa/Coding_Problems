class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length == 0) return false;
        Map<Integer, List> map = new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            if(map.get(nums[i]) != null){
                List<Integer> temp = map.get(nums[i]);
                for(int j=0;j<temp.size();j++){
                    System.out.println(Math.abs(i-temp.get(j)));
                    if(Math.abs(i-temp.get(j)) <= k) return true;
                }
                temp.add(i);
                map.put(nums[i],temp);
            }
            else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i],list);
            }
        }
        return false;
    }
}


// A much better solution

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                if(i-map.get(nums[i]) <= k) return true;
            }
            map.put(nums[i],i);
        }
        return false;
    }
}