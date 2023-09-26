package DP;

import java.util.Arrays;

public class DP_6 {
    public static int maxMoney(int arr[],int index,int []dp){
        if(index == 0)return arr[index];
        if(index < 0)return 0;
        if(dp[index] != -1)return dp[index];
        int pick =Integer.MIN_VALUE;
        pick = maxMoney(arr, index - 2,dp) + arr[index];
        int notPick = maxMoney(arr, index - 1,dp);
        return dp[index] = Math.max(pick, notPick);
    }
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,4};
        int n = arr.length;
        int [] dp = new int[10000];
        Arrays.fill(dp,-1);
        System.out.println("ans : "+maxMoney(arr,n-1,dp));
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
