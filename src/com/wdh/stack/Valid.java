package com.wdh.stack;

import java.util.Stack;

/**
 * @author wdh0713
 * @version 1.0
 * @date 2022/5/20 11:44
 */
public class Valid {
    public static void main(String[] args) {
    }

    public static boolean isValid(String s){
        if(s == null || s.length() == 0){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for(int i =0; i<s.length();i++){
            Character chr = s.charAt(i);
            if(chr == '(' || chr == '[' || chr == '{'){
                stack.push(chr);
            }
            if(chr == ')' && (stack.empty() ||stack.pop() != '(')){
                return false;
            }
            if(chr == ']' && (stack.empty() || stack.pop() != '[')){
                return false;
            }
            if(chr == '}' && (stack.empty() || stack.pop() != '{')){
                return false;
            }
        }
        return stack.empty();
    }
}
