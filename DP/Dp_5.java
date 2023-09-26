package DP;

import java.util.Arrays;

public class Dp_5 {
    public static int maxSub(int [] arr,int index,int[] dp){
        if(index == 0)return Math.max(arr[index], arr[arr.length - 1]);
        if(index < 0)return 0;
        if(dp[index] != -1)return dp[index];
        int pick =Integer.MIN_VALUE;
        pick = maxSub(arr, index - 2,dp) + arr[index];
        int notPick = maxSub(arr, index - 1,dp);
        return dp[index] = Math.max(pick, notPick);
    }
    public static void main(String[] args) {
        int arr[] = new int[]{2,1,4,9};
        int n = arr.length;
        int [] dp = new int[10000];
        Arrays.fill(dp,-1);
        System.out.println("ans : "+maxSub(arr,n-2,dp));
        Arrays.fill(dp,-1);
        dp[0] = arr[0];
        for(int i = 1;i < n;i++){
            int pick = arr[i];
            if(i >= 2 )
            pick = dp[i - 2] + arr[i];
            int notPick = dp[i-1];
            dp[i] = Math.max(pick, notPick); 
        }
        System.out.println("ans : "+dp[n - 1]);
    }
    
}
