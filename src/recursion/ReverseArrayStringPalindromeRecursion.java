package recursion;

/***
 @author: Pratiksha Kulkarni
 date: 3/3/2023
 */
public class ReverseArrayStringPalindromeRecursion {
    public static void main(String[] args) {
        int[] a = {5, 4, 3, 2, 1};
        reverseArray(0, a.length - 1, a);
        for (int i : a) System.out.println(i);
    }

    private static void reverseArray(int l, int r, int[] a) {
        if (l >= r) return;
        swap(l, r,a);
        reverseArray(l + 1, r - 1, a);
    }


    private static void swap(int x, int y,int[] a) {
        a[x] = a[x]+a[y];
        a[y] = a[x]-a[y];
        a[x] = a[x]-a[y];
    }

}
