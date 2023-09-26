package DP;

import java.util.Arrays;

public class Dp_3 {
    public static int minJump(int[] arr,int i,int[]dp){
        if(i == 0)return 0;
        if(dp[i]!=-1)return dp[i];
        int left = minJump(arr, i - 1,dp) +  Math.abs(arr[i - 1] - arr[i]);
        int right = Integer.MAX_VALUE;
        if(i > 1)
        right =  minJump(arr, i - 2,dp) + Math.abs(arr[i] - arr[i - 2]);
        return dp[i] = Math.min(left,right);
    }
    public static void main(String[] args) {
        int arr[] = new int[]{10,20,30,10};
        int n = arr.length ;
        int dp[] =  new int[1000];
        Arrays.fill(dp,-1);
        System.out.println(" ans : "+minJump(arr,n - 1,dp));
        Arrays.fill(dp,-1);
        dp[0] = 0;
        for(int i = 1;i<n;i++){
            int left = dp[i-1] + Math.abs(arr[i - 1] - arr[i]);
            int right  = Integer.MAX_VALUE;
            if (i > 1) 
            right  = dp[i-2] + Math.abs(arr[i - 2] - arr[i]);
            dp[i] = Math.min(left, right);
        }
        System.out.println(" ans : "+ dp[n - 1 ]);
    }
    
}
