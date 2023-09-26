package array;
import java.util.Arrays;

public class MergeSorted {

    public static void swap(int[] arr1,int[] arr2,int i ,int j){
        int temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
    }
    public static void main(String[] args) {
        int arr1[] = new int[] { 1, 3, 5, 7 };
        int arr2[] = new int[] { 0, 2, 6, 8, 9 };
        // brute
        int n1 = arr1.length;
        int n2 = arr2.length;
        int arr3[] = new int[n1 + n2];
        int i = 0, j = 0, k = 0;
        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                arr3[k++] = arr1[i++];
            } else {
                arr3[k++] = arr2[j++];
            }
        }
        while (i < n1) {
            arr3[k++] = arr1[i++];
        }
        while (j < n2)
            arr3[k++] = arr2[j++];

        System.out.println("arr : "+ Arrays.toString(arr3));

        // optimal 1 
        // int left  = n1 - 1;
        // int right = 0;

        // while(left >= 0 && right < n2){
        //     if( arr1[left] > arr2[right] ){
        //         int temp = arr1[left];
        //         arr1[left] = arr2[right];
        //         arr2[right] = temp;
        //     }
        //     left--;
        //         right++;
        // }
        // Arrays.sort(arr1);
        // Arrays.sort(arr2);
        // System.out.println("arr : "+ Arrays.toString(arr1));
        // System.out.println("arr : "+ Arrays.toString(arr2));

        //optimal 2
        int len = n1 + n2;
        
        int gap = ( len / 2 ) + ( len % 2 );

        while( gap > 0){
            int left = 0;
            int right = left + gap;
            System.out.println("Gap : "+gap);
            while( right < len ){
               
                if(left  < n1 && right >= n1){
                    if(arr1[left] > arr2[right - n1]){
                       
                    swap(arr1, arr2, left,right - n1 );
                   
                }
                }
                else if(left >= n1){
                    if(arr1[left - n1] > arr2[right - n1]){
                        if(gap == 1 ){
                            System.out.println(arr1[left - n1] +" "+arr2[right - n1]);
                        }
                    swap(arr1, arr2, left - n1,right - n1 );
                }
                }
                else {
                    if(gap == 1 ){
                        System.out.println("h"+left +" "+ right);
                    }
                    if(arr1[left] > arr1[right]){
                    swap(arr1, arr1, left,right );
                }
                }
                left++ ; right++;
            }
            System.out.println("arr : "+ Arrays.toString(arr1));
            System.out.println("arr : "+ Arrays.toString(arr2));
            if(gap == 1)break;
            gap = ( gap / 2 ) + ( gap % 2 ) ;
        }
       
    }

}
