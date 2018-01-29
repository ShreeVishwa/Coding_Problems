// Simple solution but long time complexity. Not required!!

class Solution {
    
    public boolean isPali(String s1, String s2){
        int m = s1.length(), n = s2.length();
        int i = 0, j = n-1;
        while(i<m && j>=0){
            if(s1.charAt(i) != s2.charAt(j)) return false;
            i++;
            j--;
        }
        int k = m-1;
        while(i<=k){
            if(s1.charAt(i) != s1.charAt(k)) return false;
            i++;
            k--;
        }
        int l = 0;
        while(j>=l){
            if(s2.charAt(j) != s2.charAt(l)) return false;
            j--;
            l++;
        }
        return true;
    }
    
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<words.length-1;i++){
            for(int j=i+1;j<words.length;j++){
                if(isPali(words[i],words[j])){
                    List<Integer> ans = new ArrayList<>();
                    ans.add(i);
                    ans.add(j);
                    res.add(ans);
                }
                if(isPali(words[j],words[i])){
                    List<Integer> ans = new ArrayList<>();
                    ans.add(j);
                    ans.add(i);
                    res.add(ans);
                }
            }
        }
        return res;
    }
}


// A much better implementation with a minor difference from the above logic

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<words.length;i++) map.put(words[i],i);
        for(int i=0;i<words.length;i++){
            for(int j=0;j<=words[i].length();j++){
                String str1 = words[i].substring(0,j);
                String str2 = words[i].substring(j);
                if(isPali(str1)){
                    String str2rev = new StringBuilder(str2).reverse().toString();
                    if(map.containsKey(str2rev) && map.get(str2rev) != i){
                        List<Integer> ans = new ArrayList<>();
                        ans.add(map.get(str2rev));
                        ans.add(i);
                        res.add(ans);
                    }
                }
                if(isPali(str2)){
                    String str1rev = new StringBuilder(str1).reverse().toString();
                    if(map.containsKey(str1rev) && map.get(str1rev) != i && str2.length() != 0){
                        List<Integer> ans = new ArrayList<>();
                        ans.add(i);
                        ans.add(map.get(str1rev));
                        res.add(ans);
                    }
                }
            }
        }
        return res;
    }
    
    public boolean isPali(String s){
        int i = 0, j = s.length()-1;
        while(i<=j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}