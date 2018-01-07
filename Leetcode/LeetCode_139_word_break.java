class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] wbreak = new boolean[s.length()+1];
        wbreak[0] = true;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(wbreak[j] && wordDict.contains(s.substring(j,i))){
                    wbreak[i] = true;
                    break;
                }
            }
        }
        return wbreak[s.length()];
    }
}