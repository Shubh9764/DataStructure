package DP;

import java.util.Arrays;

public class DP_7 {

    public static int maxPoints(int[][] arr, int day, int last,int [][]dp) {
        if (day < 0)
            return 0;
        if(dp[day][last] != -1) return dp[day][last]; 
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            if (i != last) {
                int curr = arr[day][i] + maxPoints(arr, day - 1, i,dp);
                max = Math.max(max, curr);
            }
        }
        return dp[day][last] = max;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][] {
                { 1, 2, 5 },
                { 3, 1, 1 },
                { 3, 3, 3 }
        };
        int n = arr.length; 
        int[][] dp = new int[100][4];
        for(int[] curr : dp)
        Arrays.fill(curr,-1);
        System.out.println("Ans : "+maxPoints(arr, n - 1 , 0,dp));

        for(int[] curr : dp)
        Arrays.fill(curr,-1);

        dp[0][0] = Math.max(arr[0][1],arr[0][2]);
        dp[0][1] = Math.max(arr[0][0],arr[0][2]);
        dp[0][2] = Math.max(arr[0][0],arr[0][1]);

        for(int i = 1; i < n ;i++){
            dp[i][0] = Math.max(dp[i - 1][1],dp[i - 1][2]) + arr[i][0];
        dp[i][1] = Math.max(dp[i - 1][0],dp[i - 1][2]) + arr[i][1];
        dp[i][2] = Math.max(dp[i - 1][0],dp[i - 1][1]) + arr[i][2];
        }
        System.out.println("Ans : "+Math.max(Math.max(dp[n - 1][0],dp[n - 1][1]),dp[n - 1][2]));
    }

}
