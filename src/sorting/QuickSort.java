package sorting;

/***
 @author: Pratiksha Kulkarni
 date: 9/4/2022
 */
public class QuickSort {

    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int partitionArray(int[] A, int low, int high) {
        int i = low - 1,temp=0;
        int pivot = A[high];
        for(int j=low;j<=high-1;j++){
            if(A[j]<=pivot){
                i++;
                swap(A,i,j);
            }
        }
        swap(A,i+1,high);
        return i+1;
    }

    public void quickSort(int[] A, int low, int high) {
        if (low < high) {
            int pivot = partitionArray(A,low,high);
            quickSort(A,low,pivot-1);
            quickSort(A,pivot+1,high);
        }

    }

    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        int[] A = new int[]{14, 7, 3, 12, 9, 11, 6, 2};
        sort.quickSort(A, 0, A.length-1);
        for(int i : A)
            System.out.print(i+" ");
    }
}
