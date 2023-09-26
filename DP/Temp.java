package DP;

public class Temp {
    public static int getMin(int [] arr,int i,int j){
        int min = Integer.MAX_VALUE;
        for(;i <= j ;i++){
            min = Math.min(arr[i], min);
        }
        return min;
    }
    public static int rec(int arr[],int i,int j){
        if( i >= j )return 2 * arr[i];
        int left = rec(arr, i + 1, j) + ((j - i + 1) * arr[i]) + getMin(arr, i, j);
        int right = rec(arr, i, j - 1) + ((j - i + 1) * arr[j]) + getMin(arr, i, j);
        return Math.max(left, right);
    }
    public static void main(String[] args) {
        int arr[] = new int[]{2,3,4};
        int N = arr.length;

        System.out.println(rec(arr, 0, N - 1));


    }
    
}
