class Solution {
    public int repeatedStringMatch(String A, String B) {
        int lenA = A.length();
        int lenB = B.length();
        if(lenA > lenB && A.contains(B)) return 1;
        StringBuilder sb = new StringBuilder();
        sb.append(A);
        int count = 1;
        while(sb.indexOf(B) < 0){
            if(sb.toString().length() - A.length() > B.length()) return -1;
            sb.append(A);
            count++;
        }
        return count;
    }
}