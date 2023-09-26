package array;
/**
 * PrintSpiral
 */
public class PrintSpiral {

    public static void main(String[] args) {
        int[][] a = new int[][] {
                { 1, 2, 3, 4, 5, 6 },
                { 20, 21, 22, 23, 24, 7 },
                { 19, 32, 33, 34, 25, 8 },
                { 18, 31, 36, 35, 26, 9 },
                { 17, 30, 29, 28, 27, 10 },
                { 16, 15, 14, 13, 12, 11 }
        };

        int top = 0, left = 0, right = a[0].length - 1, bottom = a.length - 1;

        while (top <= bottom && left <= right) {

            for (int i = left; i <= right; i++) {
                System.out.print(a[top][i]+" ");
            }
            System.out.println();
            top++;
            for (int i = top; i <= bottom; i++) {
                System.out.print(a[i][right]+ " ");
            }
            right--;
            System.out.println();
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    System.out.print(a[bottom][i]+ " ");
                }
            }
            bottom--;
            System.out.println();
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(a[i][left]+ " ");
                }
            }
            System.out.println();
            left++;
        }
    }
}