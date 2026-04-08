package Practical;

public class MergeSort {

    void merge(int arr[], int left, int mid, int right) {
        int i = left, j = mid + 1, k = 0;
        int temp[] = new int[right - left + 1];

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (i = left, k = 0; i <= right; i++, k++) {
            arr[i] = temp[k];
        }
    }

    void sort(int arr[], int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            sort(arr, left, mid);
            sort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    public static void main(String[] args) {
        int arr[] = {5, 2, 4, 6, 1, 3};

        MergeSort obj = new MergeSort();
        obj.sort(arr, 0, arr.length - 1);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
