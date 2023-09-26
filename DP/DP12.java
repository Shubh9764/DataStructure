package DP;

import java.util.Arrays;

public class DP12 {
    public static int ans(int [][]a ,int i,int j,int dp[][]){
         if(i < 0 || j < 0 || j >= a[0].length)
          return (int)-1e9;
        if(i == 0 )return  dp[i][j] = a[i][j];
        if(dp[i][j]!= -1)return dp[i][j];
        int left = a[i][j] + ans(a,i-1,j-1,dp);
        int right = a[i][j] + ans(a,i-1,j+1,dp);
        int bottom = a[i][j] + ans(a,i-1,j,dp);

        return dp[i][j] = Math.max(right,Math.max(left,bottom));

    }
    public static void main(String[] args) {
        int a [][] = new int[][]{
            {1,2,10,4},
            {100,3,2,1},
            {1,1,20,2},
            {1,2,2,1}
        };
        int n = a.length;

        int [][]dp = new int[n][n];
        for(int []curr : dp){
            Arrays.fill(curr,-1);
        }
        int max = Integer.MIN_VALUE;
        for(int j= n-1 ;j >=0 ;j--){
            max = Math.max(max , ans(a, n-1,j,dp));
        }
        for(int i = 0 ;i < n ;i++){
                for(int j = 0;j < a[i].length;j++){
            System.out.print(dp[i][j]+ " ");
                    
                }
                System.out.println();
            }
        System.out.println(max);
        for(int []curr : dp){
            Arrays.fill(curr,-1);
        }
         int [] prev = new int[n];
         

        for(int j=0 ;j<n;j++){
            // dp[0][j] = a[0][j];
            prev[j] = a[0][j];
        }
        System.out.println(Arrays.toString(prev));
        max =Integer.MIN_VALUE;
        for(int i = 1 ;i <n;i++ ){
            int [] curr = new int[n];
            for(int j=0;j<n;j++){
                // int left = a[i][j] +  (int)(j > 0?dp[i-1][j-1]:-1e9);
                int left = a[i][j] +  (int)(j > 0?prev[j-1]:-1e9);
                // int right  = a[i][j] +  (int)(j+1 < n?dp[i-1][j + 1]:-1e9);
                int right  = a[i][j] +  (int)(j+1 < n?prev[j + 1]:-1e9);
                int bottom = a[i][j] + prev[j];
                curr[j] = Math.max(left,Math.max(right,bottom));
            }
            prev = curr;
            System.out.println(Arrays.toString(prev));
        }
    
        for(int j = 0 ;j < n ;j++){
             max = Math.max(max, prev[j]);
        }
        System.out.println(Arrays.toString(prev));

        System.out.println(max);


        
    }
    
}
