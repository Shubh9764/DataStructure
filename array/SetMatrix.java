package array;
import java.util.Arrays;

public class SetMatrix {
    public static void markRow(int[][] a, int i) {
        System.out.println("markRow :" + a[0].length);
        for (int j = 0; j < a[0].length; j++) {
            if (a[i][j] != 0)
                a[i][j] = 0;
        }
    }

    public static void markCol(int[][] a, int j) {
        System.out.println("markCol :" + a.length);
        for (int i = 0; i < a.length; i++) {
            if (a[i][j] != 0)
                a[i][j] = 0;
        }
    }

    public static void main(String[] args) {

        int[][] a = new int[][] {
                { 0, 1, 1, 1 },
                { 1, 0, 0, 1 },
                { 1, 1, 0, 1 },
                { 1, 1, 1, 1 }
        };

        // Brute Approach

        // for(int i=0;i<a.length;i++){
        // for(int j=0;j<a[0].length;j++){
        // System.out.print(a[i][j]+ " ");
        // }
        // System.out.println();
        // }
        // System.out.println("rows :"+a.length);
        // System.out.println("cols :"+a[0].length);
        // for(int i=0;i<a.length;i++){
        // for(int j=0;j<a[0].length;j++){
        // if(a[i][j] == 0 ){
        // markRow(a, i);
        // markCol(a, j);
        // }
        // }
        // }

        // for(int i=0;i<a.length;i++){
        // for(int j=0;j<a[0].length;j++){
        // System.out.print(a[i][j]+ " ");
        // }
        // System.out.println();
        // }

        // System.out.println("--------------------------------------");

        // for(int i=0;i<a.length;i++){
        // for(int j=0;j<a[0].length;j++){
        // if(a[i][j] == -1 ){
        // a[i][j] = 0;
        // }
        // }
        // }
        // for(int i=0;i<a.length;i++){
        // for(int j=0;j<a[0].length;j++){
        // System.out.print(a[i][j]+ " ");
        // }
        // System.out.println();
        // }

        // Better Approach

        int m = a.length;
        int n = a[0].length;

        // int row[] = new int[m];

        // int col[] = new int[n];

        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (a[i][j] == 0) {
        //             row[i] = 1;
        //             col[j] = 1;
        //         }
        //     }
        // }

        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (row[i] == 1 || col[j] == 1){
        //             a[i][j] = 0;
        //         }
        //     }
        // }

        // for (int i = 0; i < a.length; i++) {
        //     for (int j = 0; j < a[0].length; j++) {
        //         System.out.print(a[i][j] + " ");
        //     }
        //     System.out.println();
        // }


        // optimal
        int col = -1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 0) {
                    a[i][0] = 0;
                    if(j!=0)
                    a[0][j] = 0;
                    else
                    col = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (a[i][0] == 0 || a[0][j] == 0) {
                    a[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            if(a[0][0] == 0){
                a[i][0] = 0;
            }
        }
        for (int i = 0; i < a.length; i++) {
            if(col == 0){
                a[0][i] = 0;
            }
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
       
    }
}
