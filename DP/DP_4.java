package DP;

public class DP_4 {

    public static int minJump(int arr[], int index, int k) {
        if (index == 0)
            return 0;
        int min = Integer.MAX_VALUE;
        for (int j = 1; j <= k; j++) {
            if (index - j >= 0) {
                int curr = minJump(arr,index - j ,k) + Math.abs(arr[index] - arr[index - j]);
                min = Math.min(min, curr);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int arr[] = new int[] { 30,10,60,10,60,50};
        int n = arr.length - 1;
        int k = 3;
        System.out.println("ans : " + minJump(arr, n, k));

    }

}
