class Solution {
    public String frequencySort(String s) {
        int max = 0;
        int[] count = new int[256];
        for(char ch : s.toCharArray()){
            count[ch]++;
            max = Math.max(max,count[ch]);
        }
        String[] bucket = new String[max+1];
        for(int i=0;i<256;i++){
            String str = bucket[count[i]];
            if(count[i] > 0){
                bucket[count[i]] = (str == null) ? "" + (char)i : str + (char)i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=max;i>=0;i--){
            if(bucket[i] != null){
                for(Character ch : bucket[i].toCharArray()){
                    for(int j=0;j<i;j++) sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
}