import java.util.Scanner;

public class Test {
    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        if (t >= 0 && t <= 500) {
            for (int i = 0; i < t; i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                int n = in.nextInt();
                if ((a >= 0 && a <= 50) && (b >= 0 && b <= 50) && (n >= 1 && n <= 15)) {
                    int A = a + b;
                    System.out.printf("%d ", A);
                    if (n >= 1) {
                        for (int x = 1; x < n; x++) {
                            A += pow(x) * b;
                            System.out.printf("%d ", A);
                        }
                        System.out.println();
                    }
                }
            }
        }
        in.close();
    }

    private static int pow(int exp) {
        int x = 1;
        for (int i = 0; i < exp; i++) {
            x = 2 * x;
        }
        return x;
    }
}
