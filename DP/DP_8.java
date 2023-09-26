package DP;

import java.util.Arrays;

public class DP_8 {

    public static int totalPaths(int i ,int j,int[][] dp){
        if(i == 0 && j == 0)return 1;
        if(i<0 || j<0)return 0;
        if(dp[i][j] != -1)return dp[i][j];
        int bottom = totalPaths(i, j - 1,dp) ;
        int left = totalPaths(i - 1, j,dp);
        return dp[i][j] =  left + bottom; 

    }
    public static void main(String[] args) {
        int m = 4, n = 4;
        int dp[][] = new int[m][n];
        for (int[] is : dp) {
            Arrays.fill(is,-1);
        }
        System.out.println("Ans : "+ totalPaths(m - 1, n - 1,dp));
        for (int[] is : dp) {
            Arrays.fill(is,0);
        }
        for(int i = 0;i < m ;i++){
            dp[i][0] = 1;
        }
        for(int i = 0;i < n ;i++){
            dp[0][i] = 1;
        }
        for(int i = 1 ;i < m ;i++){
            for(int j = 1;j < n;j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j-1];
            }
        }
        for(int i = 0 ;i < m ;i++){
            for(int j = 0;j < n;j++){
        System.out.print(dp[i][j]+ " ");
                
            }
            System.out.println();
        }
        System.out.println("Ans : "+dp[m - 1][n - 1]);



    }
    
}
