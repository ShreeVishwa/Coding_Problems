class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0) dp[i][j] = Integer.parseInt(String.valueOf(matrix[i][j]));
                else if(matrix[i][j] == '0') dp[i][j] = 0;
                else dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i][j-1], dp[i-1][j])) + 1;
            }
        }
        int[] max = new int[m];
        for(int i=0;i<m;i++){
            int max_val = Integer.MIN_VALUE;
            for(int j=0;j<n;j++){
                if(dp[i][j] > max_val) max_val = dp[i][j]; 
            }
            max[i] = max_val;
            // System.out.println(max_val);
        }
        int side = Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            if(max[i] > side) side = max[i];
        }
        return side*side;
    }
}