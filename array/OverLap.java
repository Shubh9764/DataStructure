package array;
import java.util.Arrays;

public class OverLap {
    public static void main(String[] args) {
        int [][] arr = new int[][]{
            {1,3},{2,6},{8,9},{9,11},{8,10},{2,4},{15,18},{16,17}
        };

        int n = arr.length;
        Arrays.sort(arr,(a,b) -> a[0] - b[0]);
        
        for(int i = 0; i < n; i++){
            System.out.println("arr : "+Arrays.toString(arr[i]));
        }
        int start = arr[0][0];
        int end = arr[0][1];
        for(int i = 1; i < n; i++){
            if(end >= arr[i][0]){
                end = Math.max(end,arr[i][1]);
            }
            else{
                System.out.println(" ( " + start + " , "+end+ ")");
                start = arr[i][0];
                end = arr[i][1];
            }
        }
        System.out.println(" ( " + start + " , "+end+ ")");
    }
    
}
