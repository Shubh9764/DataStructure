package array;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

import javax.activation.MimeType;

/**
 * LCS
 */
public class LCS {

    


public static void main(String[] args) {
    Integer a[] = new Integer[]{100,102,103,101,101,3,2,3,2,1,1,1,2};   
    int  n = a.length;
    HashSet<Integer> hashSet = new HashSet<>(Arrays.stream(a).collect(Collectors.toSet()));
    int lar = 1;
    int loop = 1;
    for(Integer curr : hashSet){
        if(!hashSet.contains(curr - 1)){
            int ct = 1;
            while(hashSet.contains(curr+1)){
                curr++;
                ct++;
                loop++;
            }
            lar = Math.max(lar, ct);
        }
    }
    System.out.println(" loop : "+loop);
    System.out.println(" lar : "+lar);

    Arrays.sort(a); 
    int ct = 1;
    int lst = Integer.MIN_VALUE; 
    int lmax = 1;
    for(int i=0;i<n;i++){
        if(a[i] - 1 == lst){
            lst = a[i];
            ct++;
        }
        else if(a[i] != lst){
            lst = a[i];
            ct = 1; 
        }
      lmax = Math.max(lmax, ct);
    }
    System.out.println(" ans : "+lmax);


}

}