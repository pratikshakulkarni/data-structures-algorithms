package sortingAlgorithms;

/***
 @author: Pratiksha Kulkarni
 date: 9/4/2022
 */
public class BubbleSort {

    public void bubbleSort(int[] A) {
        int n = A.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
    }

    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
        int[] A = new int[]{14, 7, 3, 12, 9, 11, 6, 2};
        sort.bubbleSort(A);
        for (int i : A)
            System.out.print(i + " ");
    }
}
