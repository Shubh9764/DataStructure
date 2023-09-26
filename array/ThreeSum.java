package array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class ThreeSum {
    public static void main(String[] args) {
        int arr[] = new int[] { -1, 0, 1, 2, -1, -4 };
        HashSet<ArrayList<Integer>> ans = new HashSet<>();
        int sum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            HashSet<Integer> hashSet = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                if (hashSet.contains(sum - (arr[i] + arr[j]))) {
                    ArrayList<Integer> triplet = new ArrayList<>(
                            Arrays.asList(arr[i], arr[j], sum - (arr[i] + arr[j])));
                    triplet.sort((a, b) -> Integer.compare(a, b));
                    ans.add(triplet);
                }
                hashSet.add(arr[j]);
            }
        }
        System.out.println(" ans : " + ans);

        // optimal
        arr = new int[] { -2, -2, -2, -1, -1, -1, 0, 0, 0, 2, 2, 2, 2 };
        n = arr.length;
        Arrays.sort(arr);
        int last = Integer.MIN_VALUE;
        ans = new HashSet<>();
        for (int i = 0; i < n - 3; i++) {
            if (arr[i] == last) {
                continue;
            }
            last = arr[i];
            int j = i + 1;
            int k = n - 1;
            while (j < k) {

                if (arr[i] + arr[j] + arr[k] == sum) {
                    System.out.println("hi");
                    System.out.println(arr[i] +" " +arr[j]+" " +arr[k]);
                    ArrayList<Integer> triplet = new ArrayList<>(Arrays.asList(arr[i], arr[j], arr[k]));
                    ans.add(triplet);
                    j++;
                    k--;
                    while(j < k && arr[j] == arr[j-1])j++;
                    while(j < k && arr[k] == arr[k+1])
                    k--;
                } else if (arr[i] + arr[j] + arr[k] < sum) {
                    j++;
                } else
                    k--;
            }
        }

        System.out.println("Optimum ans : " + ans);

    }

}
