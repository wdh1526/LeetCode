package com.wdh.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wdh0713
 * @version 1.0
 * @date 2022/5/20 17:04
 */
public class ParenTheses {
    public static void main(String[] args) {
        ParenTheses parenTheses = new ParenTheses();
        System.out.println(parenTheses.generateParenTheses(3));
    }

    public ParenTheses() {
        res = new ArrayList<>();
    }

    private  List<String> res;

    public  List<String> generateParenTheses(int n){
        backtrack(new StringBuilder(), 0,0,n);
        return res;
    }

    private void backtrack(StringBuilder builder, int open, int close, int n){
        if(open + close == 2*n){
            res.add(builder.toString());
            return;
        }
        if(open<n){
            builder.append('(');
            backtrack(builder,open+1, close,n);
            builder.deleteCharAt(builder.length()-1);
        }
        if(close<open){
            builder.append(')');
            backtrack(builder,open,close+1, n);
            builder.deleteCharAt(builder.length()-1);
        }
    }
}
