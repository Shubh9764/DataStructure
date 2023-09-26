package DP;

import java.util.Arrays;
import java.util.Scanner;

public class Dp_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]dp = new int[10000];
        Arrays.fill(dp, -1);
        // dp[0] = 0;
        // dp[1] = 1;
        int prev2 = 0;
        int prev1 = 1;
        int curr = 0;
        for(int i=2;i<=n;i++){
            // dp[i] = dp[i-1] + dp[i-2];
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        // System.out.println(n+ "th fib : "+dp[n]);
        System.out.println(n+ "th fib : "+curr);
    }
}
