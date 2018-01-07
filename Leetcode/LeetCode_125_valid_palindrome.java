class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 0) return true;
        s = s.toLowerCase();
        char[] st = s.toCharArray();
        int i=0,k=0;
        while(i<s.length()){
            if((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9')){
                st[k++] = st[i];
            }
            i++;
        }
        // System.out.println(k);
        int l =  0 ,r = k-1;
        while(l<=r){
            if(st[l] != st[r]) return false;
            l++;
            r--;
        }
        return true;
    }
}