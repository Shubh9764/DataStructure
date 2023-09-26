package DP;

import java.util.Arrays;

public class Dp11 {
    public static int ans(int [][] a ,int i,int j,int[][]dp){
        if(i >= a.length)return 0;
        if(dp[i][j] != -1)return dp[i][j];
        int bottom = a[i][j] + ans(a, i+1, j,dp);
        int dig = a[i][j] + ans(a,i+1,j+1,dp);
        return dp[i][j] = Math.min(dig, bottom);
    }
    public static void main(String[] args) {
        int [][] a = new int[][]{
            {1},
            {2,3},
            {3,6,7},
            {8,9,6,10}
        };
        int n = a.length;
        int dp[][] = new int[n][n];
        for(int []curr: dp)
        Arrays.fill(curr,-1);
        System.out.println(ans(a,0,0,dp));
        for(int []curr: dp)
        Arrays.fill(curr,-1);

        int[]front =new int[n];
        int[]curr =new int[n];

        for(int j = 0;j<n;j++)
         front[j] = a[n-1][j];
        for(int i=n-2;i>=0;i--){
            for(int j=i;j>=0;j--){
                int bottom = a[i][j] +front[j];
                int dig = a[i][j] + front[j+1];
                 curr[j] = Math.min(dig, bottom);
            }
            front = curr;
        }
        // for(int i = 0 ;i < n ;i++){
        //     for(int j = 0;j < a[i].length;j++){
        // System.out.print(dp[i][j]+ " ");
                
        //     }
        //     System.out.println();
        // }
        System.out.println("ans : "+front[0]);
}
    
}
