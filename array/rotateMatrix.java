package array;
public class rotateMatrix {

    public static void main(String[] args) {

        int[][] a = new int[][] {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };
        int n = a[0].length;
        int m = a.length;
        int ans [][] = new int[m][n];

       

        // for(int i=0;i<m;i++){

        //     for(int j=0;j<n;j++){
        //         ans[j][m-1-i] = a[i][j] ; 
        //     }
        // }

        for(int i=0;i<m-1;i++){
            for(int j=i+1;j<n;j++){
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp; 
            }
        }
    
        for(int i=0;i<a.length;i++){
        for(int j=0;j<a[0].length;j++){
            System.out.print(a[i][j]+ " ");
        }
            System.out.println();
        }


    }
    
}
