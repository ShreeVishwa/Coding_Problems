class Solution {
    
    public boolean helper(String s, int i, int j){
        while(i<=j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    
    public boolean validPalindrome(String s) {
        int f = 0, l = s.length()-1, flag = 0;
        while(f<l){
            if(s.charAt(f) == s.charAt(l)) {
                f++;
                l--;
            }
            else if((s.charAt(f+1) == s.charAt(l) || s.charAt(f) == s.charAt(l-1)) && flag != 1){
                boolean res1 = helper(s,f+1,l);
                boolean res2 = helper(s,f,l-1);
                flag = 1;
                return res1 || res2;
            }
            else return false;
        }
        return true;
    }
}