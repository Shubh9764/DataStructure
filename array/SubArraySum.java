package array;
import java.util.HashMap;

/**
 * SubArraySum
 */
public class SubArraySum {
    public static int dp [] = new int[10000];

    public static int fib(int n){
        if (dp[n] != 0 ){
            return dp[n];
        }

        if(n == 0 || n == 1){
            return n;
        }
        return dp[n] = fib(n-1) + fib(n-2);
    }

    public static void main(String[] args) {
        int arr[]  = new int[]{1,2,3,-3,1,1,1,4,2,-3};
        int k = 3;
        HashMap<Integer,Integer> ans = new HashMap<>();
        ans.put(0,1);
        int preSum = 0;
        int ct = 0;
        for(int  i = 0;i < arr.length;i++){
            preSum += arr[i];
            if(ans.containsKey(preSum-k)){
                ct += ans.get(preSum - k);
            }
            ans.put(preSum,ans.get(preSum) != null ? ans.get(preSum) + 1 : 1 );
        }
        System.out.println("ans : "+ct);
        System.out.println("fib : "+fib(100));
    }
}