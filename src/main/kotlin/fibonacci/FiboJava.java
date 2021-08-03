package fibonacci;

public class FiboJava {
    public static void main(String[] args) {
        memoizationFibonacci(5);
    }

    private static int[] cache = new int[5000];

    private static int memoizationFibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (cache[n] != 0) {
            return cache[n];
        } else {
            cache[n] = memoizationFibonacci(n - 1) + memoizationFibonacci(n - 2);
            return cache[n];
        }
    }
}
