class Solution {
    public boolean isValidSudoku(char[][] board) {
        // row check
        for(int i=0;i<9;i++){
            HashSet<Character> str=  new HashSet<>();
            for(int j=0;j<9;j++){
                if(board[i][j] == '.') continue;
                if(str.contains(board[i][j])) return false;
                str.add(board[i][j]);
            }
        }
        // column check
        for(int j=0;j<9;j++){
            HashSet<Character> stc = new HashSet<>();
            for(int i=0;i<9;i++){
                if(board[i][j] == '.') continue;
                if(stc.contains(board[i][j])) return false;
                stc.add(board[i][j]);
            }
        }
        //box check
        for(int sr=0;sr<9;sr+=3){
            int er = sr+2;
            for(int sc=0;sc<9;sc+=3){
                int ec = sc+2;
                if(!valid(board,sr,er,sc,ec)) return false;
            }
        }
        return true;
    }
    public boolean valid(char[][] board,int sr,int er,int sc,int ec){
        HashSet<Character> st = new HashSet<>();
        for(int i=sr;i<=er;i++){
            for(int j=sc;j<=ec;j++){
                if(board[i][j] == '.'){
                    continue;
                }
                if(st.contains(board[i][j])){
                    return false;
                }
                st.add(board[i][j]);
            }
        }
        return true;
    }
}