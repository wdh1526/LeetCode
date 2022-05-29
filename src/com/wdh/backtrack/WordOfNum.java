package com.wdh.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wdh0713
 * @version 1.0
 * @date 2022/5/21 09:28
 */
public class WordOfNum {
    public static void main(String[] args) {
        WordOfNum wordOfNum = new WordOfNum();
        System.out.println(wordOfNum.letterCombinations("234"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList();
        String[] str = new String[]{"","abc","def","ghi","jkl",
                "mno","pqrs","tuv","wxyz"};
        backtrack(digits, res, str, 0, new StringBuilder());
        return res;
    }

    private void backtrack(String digits, List<String> res, String[] str, int cur, StringBuilder builder){
        if(cur == digits.length()){
            res.add(builder.toString());
        } else {
            char chr = digits.charAt(cur);
            String s = str[chr-'1'];
            for(int i=0; i<s.length();i++){
                builder.append(s.charAt(i));
                backtrack(digits, res, str, cur+1, builder);
                builder.deleteCharAt(builder.length()-1);
            }
        }
    }
}
