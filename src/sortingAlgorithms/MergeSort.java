package sortingAlgorithms;

/***
 @author: Pratiksha Kulkarni
 date: 9/4/2022
 */
public class MergeSort {
    public void merge(int[] A, int low, int mid, int high) {

        //length of 2 sub-arrays
        int l1 = (mid-low)+1 ;
        int l2 = high - (mid);

        //create auxiliary arrays for 2 sub-arrays
        int[] SA1 = new int[l1];
        int[] SA2 = new int[l2];

        //fill both arrays with SA elements
        for (int i = 0; i < l1; i++)
            SA1[i] = A[low+i];

        for (int i = 0; i < l2; i++)
            SA2[i] = A[(mid +1)+ i];

        int k = low, i = 0, j = 0;

        while (i < l1 && j < l2) {
            if (SA1[i] <= SA2[j]) {
                A[k] = SA1[i];
                i++;
            } else {
                A[k] = SA2[j];
                j++;
            }
            k++;
        }

        while (i < l1) {
            A[k] = SA1[i];
            i++;k++;
        }

        while (j < l2) {
            A[k] = SA2[j];
            j++;k++;
        }
    }

    public void mergeSort(int[] A, int low, int high) {
     if(low<high) {
      int mid = (low + high) / 2;
      mergeSort(A, low, mid);
      mergeSort(A, mid+1, high);
      merge(A, low, mid, high);
     }
    }

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        int[] A = new int[]{14, 7, 3, 12, 9, 11, 6, 2};
        sort.mergeSort(A, 0, A.length - 1);
        for(int i : A){
         System.out.print(i+" ");
        }
    }
}
