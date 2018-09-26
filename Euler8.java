package euler;

import java.util.Scanner;

/***
 * 
 * 
 * 
 * 
 * 2 10 5 3675356291 10 5 2709360626
 * 
 * 3150 0
 * 
 * @author kriprakash
 *
 */
public class Euler8 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            int k = in.nextInt();
            String num = in.next();
            int max = Integer.MIN_VALUE;
            int prod = 1;
            for (int i = 0; i <= num.length() - k; i++) {
                prod = 1;
                int count = i;
                for (int j = 0; j < k; j++, count++) {
                    int x = Character.getNumericValue(num.charAt(count));
                    System.out.print(x+" ");
                    prod = prod * x;
                }
                System.out.println();
                if (prod > max)
                    max = prod;

            }
            System.out.println(max);
        }
    }
}
