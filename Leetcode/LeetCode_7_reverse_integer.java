class Solution {
    public int reverse(int x) {
        int sign = 1;
        if(x < 0) {
            sign = -1;
            x = -x;
        }
        long num = 0;
        while(x > 0){
            // System.out.println(num);
            num = num*10 + (long)x%10;
            x /= 10;
        }
        if(num < Integer.MIN_VALUE || num > Integer.MAX_VALUE) return 0;
        return sign*(int)num;
    }
}