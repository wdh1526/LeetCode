package com.wdh.backtrack;

/**
 * @author wdh0713
 * @version 1.0
 * @date 2022/5/24 12:52
 */
public class SearchWord {

    public static void main(String[] args) {
        SearchWord searchWord = new SearchWord();
        char[][] board = new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        System.out.println(searchWord.exist(board,"oath"));
    }

    public boolean exist(char[][] board, String word) {
        int row = board.length, col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for(int i =0 ; i<row ; i++){
            for(int j = 0; j<col;j++){
                if(backtrack(board, word,i,j,0,visited)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int i, int j, int begin, boolean[][] visited){
        if(begin>= word.length()){
            return true;
        }
        if(i<0 || i>= board.length || j<0|| j>= board[0].length){
            return false;
        }
        if(visited[i][j]){
            return false;
        }
        if(board[i][j] != word.charAt(begin)){
            return false;
        }
        visited[i][j] =true;
        if(backtrack(board,word,i+1,j,begin+1,visited)){
            return true;
        }
        if(backtrack(board,word,i,j+1,begin+1,visited)){
            return true;
        }
        if(backtrack(board,word,i-1,j,begin+1,visited)){
            return true;
        }
        if(backtrack(board,word,i,j-1,begin+1,visited)){
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}
