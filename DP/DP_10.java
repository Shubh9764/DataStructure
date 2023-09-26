package DP;

import java.util.Arrays;

public class DP_10 {
    public static int maxSum = Integer.MAX_VALUE;
    public static int minPathSum(int [][]arr,int i,int j, int [][] dp){
        if(i == 0 && j == 0){
            return arr[i][j];
        }
        if(i < 0 || j < 0)return 10000000;
        if(dp[i][j] != -1)return dp[i][j];
        int left = arr[i][j] + minPathSum(arr, i, j - 1,dp);
        int bottom = arr[i][j]+ minPathSum(arr, i - 1 , j,dp);
        return dp[i][j] = Math.min(left, bottom);
    }

    public static void main(String[] args) {
        int [][] arr = new int[][]{
            {5,9,6},
            {11,5,2}
        };
        int n = arr.length - 1;
        int m = arr[0].length - 1; 
        int [][] dp = new int[n+1][m+1];
        for(int[] curr : dp)
          Arrays.fill(curr, -1);  
        System.out.println("Ans : "+ minPathSum(arr, n, m,dp));
          for(int[] curr : dp)
          Arrays.fill(curr, 0);  
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                System.out.println(" i = "+ i + ", j = "+j);
                if(i==0&&j==0)dp[i][j] = arr[i][j];
                
                else{
                     int up = arr[i][j] + (int)(i > 0?dp[i-1][j]:1e9);
                     int left = arr[i][j] + (int) (j > 0?dp[i][j-1]:1e9);
                     dp[i][j] = Math.min(up, left);
                    }
            }
        }
        for(int i = 0 ;i <= n ;i++){
            for(int j = 0;j <= m;j++){
        System.out.print(dp[i][j]+ " ");
                
            }
            System.out.println();
        }



    }
    
}
