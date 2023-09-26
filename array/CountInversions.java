package array;
import java.util.Arrays;

public class CountInversions {

    public static int merge(int[] a, int low, int mid, int high) {
        int ct = 0;
        int temp[] = new int[high - low +1];
        int left = low;
        int right = mid + 1;
        int k = 0;
        while (left <= mid && right <= high) {
            if (a[left] <= a[right]) {
                temp[k++] = a[left++];
            } else {
                ct += (mid - left + 1);
                temp[k++] = a[right++];
            }
        }
        while (left <= mid) {
            temp[k++] = a[left++];
        }
        while (right <= high) {
            temp[k++] = a[right++];
        }
        System.out.println("temp  : " + Arrays.toString(temp));
        for(int i=low;i<=high;i++){
            a[i] = temp[i - low ];
        }


        return ct;

    }

    public static int countInversions(int[] a, int left, int right) {
        if (left >= right)
            return 0;

        int ct = 0;
        int mid = (left + right) / 2;
        ct += countInversions(a, left, mid);
        ct += countInversions(a, mid + 1, right);
        ct += merge(a, left, mid, right);
        return ct;
    }

    public static void main(String[] args) {
        int arr[] = new int[] { 5, 3, 2, 1, 4 };
        int n = arr.length;

        // for(int i=0;i<n;i++){
        // for(int j=i+1 ;j<n;j++){
        // if(arr[i] > arr[j]){
        // System.out.print("( " +arr[i] + " , "+ arr[j] + " ) ," );
        // }
        // }
        // }
        // System.out.println("Ans  : " + countInversions(arr, 0, n - 1));
        // System.out.println("Arr  : " + Arrays.toString(arr));
     

    }

}
