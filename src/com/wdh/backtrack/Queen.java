package com.wdh.backtrack;

import java.util.*;

/**
 * @author wdh0713
 * @version 1.0
 * @date 2022/5/22 10:11
 */
public class Queen {
    private int count = 0;

    public static void main(String[] args) {
        Queen queen = new Queen();
        System.out.println(queen.solveNQueens(16));
    }

    public int solveNQueens(int n) {
        int[] queue = new int[n];
        Arrays.fill(queue, -1);
        backtrack(0, 0, 0, 0, n, queue);
        return count;
    }

    private void backtrack(int col, int dig1, int dig2, int row, int n, int[] queue){
        if(row == n){
            count++;
            return;
        }
        int availablePosition = ((1<<n)-1) & (~(col|dig1|dig2));
        while (availablePosition!=0){
            int position = availablePosition &(-availablePosition);
            availablePosition = availablePosition & (availablePosition-1);
            int colNum = Integer.bitCount(position-1);
            queue[row] = colNum;
            backtrack(col |position, (dig1|position) <<1, (dig2 | position)>>1, row+1, n, queue);
            queue[row] = -1;
        }
    }
}
