package com.wdh.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wdh0713
 * @version 1.0
 * @date 2022/5/22 17:16
 */
public class Queen2 {

    private List<List<String>> res = new ArrayList<>();

    public static void main(String[] args) {
        Queen2 queen2 = new Queen2();
        List<List<String>> res = queen2.solveNQueens(4);
        for (int i = 0; i < res.size(); i++) {
            System.out.println("第"+ (i+1) +"种解法---");
            res.get(i).forEach(System.out::println);
        }
    }

    public List<List<String>> solveNQueens(int n){
        int[] queue = new int[n];
        Arrays.fill(queue,-1);
        backtrack(n,0,0, 0, 0, queue);
        return res;
    }

    private void backtrack(int n, int col, int dig1, int dig2, int row, int[] queue){
        if(row == n){
            List<String> cur = generate(queue);
            res.add(cur);
            return;
        }
        int availablePositions = ((1<< n)-1) & (~(col | dig1| dig2));//(1<<n)-1 得到n位切都是1的数，要获取可以用的位置，采用与运算，
        //所以需要将后面的数取反
        while (availablePositions != 0){
            //负数取反码将非符号位取反，那么原来最低位1对应的反码是0，之后的后面位对应的反码是1，取补需要加1，则会将最低位位1 的位置设置为1
            int position = availablePositions & (-availablePositions); //取为1的最低位，即最后一个1是1，其他位置是0

            // 将这一位从可选取的位中移除
            // 减1把最后一个1拆成后面的多个1，再经过一次与操作把这些多出来的1全部清除
            availablePositions = availablePositions & (availablePositions -1);//最低位置0
            // 这个方法是统计一个二进制数中所有的“1”的个数
            int column = Integer.bitCount(position - 1);//获取二进制数1的位数，position后面有多少个1，那么当前位置的列标号就是几
            queue[row] = column;
            backtrack(n, col | position, (dig1 | position) <<1, (dig2 | position) >>1, row+1, queue);
            queue[row] = -1;
        }
    }

    private List<String> generate(int[] queue){
        List<String> cur = new ArrayList();
        for(int i=0; i< queue.length;i++){
            StringBuilder builder = new StringBuilder();
            for(int col =0; col < queue.length;col++){
                if(col == queue[i]){
                    builder.append(" Q ");
                } else {
                    builder.append(" * ");
                }
            }
            cur.add(builder.toString());
        }
        return cur;
    }
}
