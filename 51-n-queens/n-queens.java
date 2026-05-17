class Solution {
    List<List<String>> res = new ArrayList<>();
    int N;

    public void solve(List<String> board,int row){
        if(row>=N){
            res.add(new ArrayList<>(board));
            return;
        }
        for(int col=0;col<N;col++){
            if(isValid(board,row,col)){
                char[] rowChars = board.get(row).toCharArray();
                rowChars[col] = 'Q';
                board.set(row,new String(rowChars));
                solve(board,row+1);
                rowChars[col] = '.';
                board.set(row,new String(rowChars));
            }
            
        }
    }
    public boolean isValid(List<String> board,int row,int col){
        // look upwards
        for(int i=row-1;i>=0;i--){
            if(board.get(i).charAt(col)=='Q') return false;
        }
        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') return false;
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < N; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') return false;
        }
        return true;
    }
    public List<List<String>> solveNQueens(int n) {
        N = n;
        res = new ArrayList<>();
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            board.add(new String(row));
        }
        solve(board,0);
        return res;
        
    }
}