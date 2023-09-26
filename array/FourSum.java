package array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class FourSum {

    public static void main(String[] args) {
        
        int arr[] = new int[]{1,0,-1,0,-2,2};

        int n = arr.length;
        int sum = 0;
        HashSet<ArrayList<Integer>> ans = new HashSet<>();
        for(int i = 0;i < n; i++){
            for(int j = i + 1;j < n; j++){
                HashSet<Integer> hash = new HashSet<>();
                for(int k = j + 1;k < n;k++){
                    int l = sum - (arr[i] + arr[j] + arr[k]);   
                    if(hash.contains(l)){
                        ArrayList<Integer> quads = new ArrayList<>(Arrays.asList(arr[i],arr[j],arr[k],l));
                        quads.sort((a, b) -> Integer.compare(a, b));
                        ans.add(quads);
                    }
                    hash.add(arr[k]);
                }
            }
        }
        System.out.println("ans  : "+ans);
        // optimal 
        arr = new int[]{1,1,1,2,2,2,3,3,3,4,4,4,5,5};
        n = arr.length;
        sum = 8 ;
        Arrays.sort(arr);
        ans = new HashSet<>();
        for(int i = 0;i < n; i++){
            if( i > 0  && arr[i] == arr[i - 1] )continue;
            int j = i + 1;
            int last = arr[n - 1] + 1 ;
            while( j < n){
                if(arr[j] == last){
                    j++;
                    continue;
                    
                }
                last = arr[j];
                int  k = j + 1,l = n - 1;
                while(k < l){
                    int allSum = arr[i] + arr[j] + arr[k] + arr[l];
                    if(allSum == sum){
                        ArrayList<Integer> quads = new ArrayList<>(Arrays.asList(arr[i],arr[j],arr[k],arr[l]));
                        ans.add(quads);
                        k++;
                        l--;
                        while( k < l && arr[k] == arr[k - 1] )k++;
                        while( k < l && arr[l] == arr[l + 1] )l--;
                    }
                    else if(allSum < sum){
                        k++;
                    }
                    else
                    l--;
                }
                j++;
            }
        }
        System.out.println("Opt ans  : "+ans);
    }
    
}
