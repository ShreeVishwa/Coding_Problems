// Brute Force O(n^2) with time 601ms (11%)

class Solution {
    
    public int rotate(int[] A){
        int temp = A[0];
        for(int i=0;i<A.length-1;i++) A[i] = A[i+1];
        A[A.length-1] = temp;
        int res = 0;
        for(int i=0;i<A.length;i++) res += A[i]*i;
        return res;
    }
    
    public int maxRotateFunction(int[] A) {
        if(A.length == 0) return 0;
        int max_val = Integer.MIN_VALUE;
        for(int i=0;i<A.length;i++){
            int val = rotate(A);
            if(val > max_val) max_val = val;
        }
        return max_val;
    }
}

// Simplified O(n) Solution 5ms

class Solution {
    public int maxRotateFunction(int[] A) {
        int allSum = 0, F = 0;
        for(int i=0;i<A.length;i++){
            F += i*A[i];
            allSum += A[i];
        }
        int max = F;
        for(int i=A.length-1;i>0;i--){
            F = F + allSum - A.length*A[i];
            max = Math.max(F,max);
        }
        return max;
    }
}