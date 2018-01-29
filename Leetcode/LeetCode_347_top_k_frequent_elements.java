// Solution using priority Queue 34ms

class Solution {
    
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i]) + 1);
            }
            else map.put(nums[i],1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer,Integer>>(){
            @Override
            public int compare(Map.Entry<Integer,Integer> a, Map.Entry<Integer,Integer> b){
                return b.getValue() - a.getValue();
            }
        });
        pq.addAll(map.entrySet());
        while(k > 0){
            res.add(pq.poll().getKey());
            k--;
        }
        return res;
    }
}

// Optimised solution using bucket sort

class Solution {
    
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i]) + 1);
            }
            else map.put(nums[i],1);
        }
        List<Integer>[] bucket = new List[nums.length+1];
        for(int num : map.keySet()){
            int count = map.get(num);
            if(bucket[count] == null){
                bucket[count] = new ArrayList<>();
            }
            bucket[count].add(num);
        }
        for(int i=bucket.length-1;i>=0 && res.size() < k;i--){
            if(bucket[i] != null) res.addAll(bucket[i]);
        }
        return res;
    }
}