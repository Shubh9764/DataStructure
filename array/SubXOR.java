package array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SubXOR {
    public static void main(String[] args) {
        int arr[] = new int[]{4,2,2,6,4};
        int n = arr.length;
        int k = 6;
        HashMap<Integer,Integer> hash = new HashMap<>();

        //Brute
        for(int i = 0; i < n  ;i++){
            int xor = 0;
            ArrayList<Integer> ans  =  new ArrayList<>();
            for(int j = i ;j < n; j++){
                ans.add(arr[j]);
                xor ^= arr[j];
                // System.out.print(xor + " ");
                if(xor == k){
                    System.out.println(ans);
                }

            }
        } 

        System.out.println("___________________________________________________");
        //optimal
        int xor = 0;
        hash.put(xor, -1);
        for(int i = 0; i < n ;i++){
            xor ^= arr[i];
            System.out.println("XOR : "+(k^xor));
            if(hash.containsKey(k ^ xor)){
                int last = hash.get(k ^ xor);
                for(int t = last + 1  ;t <= i ;t++){
                    System.out.print(arr[t]+ " ");
                }
                System.out.println();
            }
            if(!hash.containsKey(xor))
            hash.put(xor,i);
        }
        System.out.println("hash : "+ hash);

    }
    
}
