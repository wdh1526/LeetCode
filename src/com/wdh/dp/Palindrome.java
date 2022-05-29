package com.wdh.dp;

/**
 * @author wdh0713
 * @version 1.0
 * @date 2022/5/29 11:36
 */
public class Palindrome {
    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.getMaxPalindrome("babad"));
    }
    
    private String getMaxPalindrome(String str){
        if(str == null || str.length() == 0) return null;
        int n = str.length();
        String res = "";
        boolean[][] dp = new boolean[n][n];
        for (int len = 0; len < n; len++) {
            for (int left = 0; left+len < n; left++) {
                int right = left+len;
                if(str.charAt(left) != str.charAt(right)){
                    dp[left][right]  = false;
                } else if(len<3){
                    dp[left][right] = true;
                } else {
                    dp[left][right] = dp[left-1][right+1];
                }
                if(dp[left][right] && len+1>res.length()){
                    res = str.substring(left,right+1);
                }
            }
        }
        return res;
    }
}
