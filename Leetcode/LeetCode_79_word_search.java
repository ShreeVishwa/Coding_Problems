class Solution {
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(exists(board,i,j,w,0)) return true;
            }
        }
        return false;
    }
    
    public boolean exists(char[][] board, int i, int j, char[] w, int l){
        if(l == w.length) return true;
        if(i<0 || j<0 || i==board.length || j==board[0].length) return false;
        if(board[i][j] != w[l]) return false;
        board[i][j] ^= 256;
        boolean exi = exists(board,i+1,j,w,l+1) || exists(board,i-1,j,w,l+1) || exists(board,i,j+1,w,l+1) || exists(board,i,j-1,w,l+1);
        board[i][j] ^= 256;
        return exi;
    }
}