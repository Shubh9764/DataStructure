package array;
import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        int n = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter No of Rows :");
        n = sc.nextInt(); 
        for (int i = 1; i <= n;i++){
            int ans = 1;
            for(int j = 0 ;j < n-i ;j++){
                System.out.print(" ");
            }
            System.out.print(ans + " ");
            for(int j = 1 ;j < i ;j++){
                ans = ans * (i - j);
                ans = ans / j;  
                System.out.print(ans + " ");
            }
            System.out.println();
        }
    }
    
}
