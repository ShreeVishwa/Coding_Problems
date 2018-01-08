class Solution {
    public String countAndSay(int n) {
        String[] dp = new String[n];
        dp[0] = "1";
        for(int i=1;i<n;i++) dp[i] = next_sequence(dp[i-1]);
        return dp[n-1];
    }
    
    public String next_sequence(String s){
        char[] ch = s.toCharArray();
        int[] count = new int[10];
        // System.out.println(ch[0]-'0');
        count[ch[0]-'0']++;
        String res = "";
        if(s.length() == 1) return res+=Integer.toString(count[ch[0]-'0']) + Character.toString(ch[0]);
        for(int i=1;i<ch.length;i++){
            if(ch[i] == ch[i-1]) count[ch[i]-'0']++;
            else{
                res += Integer.toString(count[ch[i-1]-'0']) + Character.toString(ch[i-1]);
                count[ch[i-1]-'0'] = 0;
                count[ch[i] - '0']++;
            }
        }
        res+=Integer.toString(count[ch[ch.length-1]-'0']) + Character.toString(ch[ch.length-1]);
        return res;
    }
}