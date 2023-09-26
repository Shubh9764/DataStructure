package array;

import java.util.Arrays;

public class ReversePair {
    public static int merge(int[] a ,int low ,int mid ,int high){
        int ct = 0;
        int total = 0;
        int[] temp = new int[high - low + 1]; 
        int left = low;
        int right = mid + 1;
        int k = 0;
        for(int i=low ; i<=mid ;i++){
            while(right <= high && a[i] >= (2 * a[right]) ){
                right++;
            }
            ct +=right - (mid + 1);
        }
        right = mid + 1;
        while(left <= mid && right <= high){
            if(a[left] <= a[right]){
                total += ct;
            }
            else{
                temp[k++] = a[right++];
            }
        }

        while(left <= mid ){
            temp[k++] = a[left++];
        }

        while(right <= high ){
            temp[k++] = a[right++];
        }

        for(int i = low ; i <= high ; i++){
            a[i] = temp[i - low];
        }
        return ct;
    }
    public static int recMerge(int[] a ,int left ,int right){
        int ct = 0;
        if(left >= right )return ct;
        int mid = ( left + right ) / 2;
        ct += recMerge(a, left, mid);
        ct += recMerge(a, mid+1, right);
        ct += merge(a, left, mid, right);

        return ct;
    }
    public static void main(String[] args) {
        // int arr[] = new int[]{40,25,19,12,9,6,2};
        // int n =arr.length;
        // // for(int i=0;i<n;i++){
        // //     for(int j=i+1;j<n;j++){
        // //         if(arr[i] > (2 * arr[j])){
        // //             System.out.print(" ( "+arr[i]+ ", " + arr[j] + " ), ");
        // //         }
        // //     }
        // // }

        // System.out.println("pairs : "+ recMerge(arr, 0, n - 1));
        // System.out.println("arr : "+ Arrays.toString(arr));

        Integer a = 50;
        Integer b = 50;
        Integer c = 150;
        Integer d = 150;

        if(a == b )
        System.out.println("a == b");
        else
        System.out.println("a != b");

        if(c == d )
        System.out.println("c == d");
        else
        System.out.println("c != d");
        System.out.println('j'+'a'+'v'+'a');


        

    }
    
}
