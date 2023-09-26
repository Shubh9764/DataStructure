package array;
public class Majority_II {
    public static void main(String[] args) {
        int arr [] =  new int[]{1,1,1,3,3,2,2,2}; 
        int n = arr.length;
        int check = (n / 3) + 1 ;
        int ct1 = 0 ,ct2 = 0;
        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MAX_VALUE;
        for(int i = 0; i < n ; i++){
            if(ct1 == 0  && ele2 != arr[i]){
                ct1 = 1;
                ele1 = arr[i];
            }
            else if(ct2 == 0  && ele1 != arr[i]){
                ct2 = 1;
                ele2 = arr[i];
            }
            else if(ele1 == arr[i]){
                ct1++;
            }
            else if(ele2 == arr[i]){
                ct2++;
            }
            else
            {
                ct1--;
                ct2--;
            }
        }
        ct1 = 0;
        ct2 = 0; 
        for(int i = 0;i < n ; i++){
            if(arr[i] == ele1){
                ct1++;
            }
            else if(arr[i] == ele2){
                ct2++ ;
            }
        }
        if(ct1 >= check ){
            System.out.println("Maj 1 : "+ele1);
        }
        if(ct2 >= check ){
            System.out.println("Maj 2 : "+ele2);
        }


    }
}
