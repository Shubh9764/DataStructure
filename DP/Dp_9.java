package DP;

public class Dp_9 {
    public static int uniquePaths(int[][]arr,int i,int j){
        if(i==0 && j==0){
            return arr[i][j] == 0 ? 1: 0;
        }
        if(i < 0 || j < 0 || arr[i][j] == -1)return 0;
        int left = uniquePaths(arr, i, j - 1);
        int bottom = uniquePaths(arr, i - 1, j);
        return left + bottom;
    }
    public static void main(String[] args) {
        int [][] arr = new int[][]{
            {-1,0,0},
            {0,0,0},
            {0,0,0}
        };
        int n = arr.length;
        int m = arr[0].length;

        System.out.println("Ans : "+ uniquePaths(arr, n - 1, m - 1));


    }
    
}
