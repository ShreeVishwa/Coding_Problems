// Recursive solution for the power function. Not so efficient because takes a longer time

class Solution {
    public double myPow(double x, int n) {
        if(n==0.0) return 1;
        if(n == Integer.MIN_VALUE && (x == 1.0 || x == -1.0)) return 1.0;
        if(n == Integer.MIN_VALUE) return 0;
        if(n < 0){
            n = -n;
            System.out.println(n);
            x = 1/x;
            System.out.println(x);
        }
        if(n%2 == 0) return myPow(x*x,n/2);
        return x*myPow(x*x,n/2);
    }
}

//Iterative implementation of the power function

class Solution {
    public double myPow(double x, int n) {
        if(n==0) return 1;
        if(n==Integer.MIN_VALUE && (x==1 || x==-1)) return 1.0;
        if(n==Integer.MIN_VALUE) return 0.0;
        if(n<0){
            n = -n;
            x = 1/x;
        }
        double res = 1;
        while(n>0){
            if(n%2 == 1) res *= x;
            x *= x;
            n = n>>1;
        }
        return res;
    }
}