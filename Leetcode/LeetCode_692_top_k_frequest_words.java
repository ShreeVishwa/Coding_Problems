// 18ms solution using bucketsort

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        for( String s : words){
            map.put(s,map.getOrDefault(s,0) + 1);
        }
        List<String>[] bucket = new List[words.length + 1];
        for(String key : map.keySet()){
            int count = map.get(key);
            if(bucket[count] == null) bucket[count] = new ArrayList<>();
            bucket[count].add(key);
        }
        for(int i=bucket.length-1;i>=0;i--){
            if(bucket[i] != null){
                Collections.sort(bucket[i]);
                for(String str : bucket[i]){
                    if(k > 0) {
                        res.add(str);
                        k--;
                    }
                    else return res;
                }
            }
        }
        return res;
    }
}