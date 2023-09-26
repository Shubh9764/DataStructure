package array;
public class MisAndRepiting {

    public static void main(String[] args) {
        int arr[] = new int[] { 4, 3, 6, 2, 1, 1 };
        int n = arr.length;
        // optimal 1
        int SN = n * (n + 1) / 2;
        int S2N = n * (n + 1) * (2 * n + 1) / 6;

        int S = 0, S2 = 0;

        for (int i = 0; i < n; i++) {
            S += arr[i];
            S2 += (arr[i] * arr[i]);
        }

        int val1 = S - SN;
        int val2 = S2 - S2N;
        val2 = val2 / val1;
        System.out.println(" Repeating  : " + (val1 + val2) / 2);
        System.out.println(" Missing  : " + -1 * (val1 - val2) / 2);

        // optimal 2

        int xor = 0;
        for (int i = 0; i < n; i++) {
            xor = xor ^ arr[i];
            xor ^= i + 1;
        }

        int ct = 0;
        while (true) {
            if ((xor & (1 << ct)) != 0)
                break;
            ct++;
        }
        System.out.println("ct : " + ct);
        int num1 = 0, num2 = 0;
        for (int i = 0; i < n; i++) {
            if ((arr[i] & (1 << ct)) != 0) {
                num1 ^= arr[i];
            } else {
                num2 ^= arr[i];
            }
            if (((i + 1) & (1 << ct)) != 0) {
                num1 ^= i + 1;
            } else {
                num2 ^= i + 1;
            }

        }
        System.out.println("num1 : " + num1);
        System.out.println("num2 : " + num2);

    }

}
