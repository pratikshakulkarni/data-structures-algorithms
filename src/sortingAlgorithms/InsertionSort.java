package sortingAlgorithms;

/***
 @author: Pratiksha Kulkarni
 date: 9/4/2022
 */
public class InsertionSort {
    private static void insertionSort(int[] A){
        int n = A.length;

        for(int i=1;i<n;i++){
            int key = A[i];
            int j=i-1;
            while(j>=0 && A[j] > key){
                A[j+1]=A[j];
                j--;
            }
            A[j+1]=key;
        }

        for(int i=0;i<n;i++)
            System.out.print(" " + A[i]);
    }
    public static void main(String[] args) {
        insertionSort(new int[]{25, 17, 31, 13, 2});
    }
}
