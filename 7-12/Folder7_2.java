class Folder7_2 {
    public static void V14(int[] arr1, int[] arr2) {
        int m = 0;
        int n = 0;
        while (m < arr1.length && n < arr2.length) {
            if (m > 0 && arr1[m] == arr1[m - 1]) {
                m++;
                continue;
            }
            if (arr1[m] < arr2[n]) {
                m++;
            } else if (arr1[m] > arr2[n]) {
                n++;
            } else {
                System.out.println(arr1[m]);
                m++;
                n++;
            }
        }
    }

    public static void V15(int[] arr1, int[] arr2) {
        int m = 0;
        int n = 0;
        while (m < arr1.length && n < arr2.length) {
            if (m > 0 && arr1[m] == arr1[m - 1]) {
                m++;
                continue;
            }
            if (n > 0 && arr2[n] == arr2[n - 1]) {
                n++;
                continue;
            }
            if (arr1[m] < arr2[n]) {
                System.out.println(arr1[m]);
                m++;
            } else if (arr1[m] > arr2[n]) {
                System.out.println(arr2[n]);
                n++;
            } else {
                System.out.println(arr1[m]);
                m++;
                n++;
            }
        }
        while (m < arr1.length) {
            while (m > 0 && arr1[m] == arr1[m - 1]) {
                m++;
                continue;
            }
            System.out.println(arr1[m]);
            m++;
        }
        while (n < arr2.length) {
            while (n > 0 && arr2[n] == arr2[n - 1]) {
                n++;
                continue;
            }
            System.out.println(arr2[n]);
            n++;
        }

    }

    public static int V11(int[] arr, int low, int mid, int high) {
        // this solution is theta n;
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int left[] = new int[n1];
        int right[] = new int[n2];
        for (int i = 0; i < n1; i++) {
            left[i] = arr[low + i];
        }
        for (int i = 0; i < n2; i++) {
            right[i] = arr[mid + 1 + i];
        }
        int i = 0;
        int j = 0;
        int k = low;
        int res = 0;
        // whole V11 function
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                k++;
                i++;
            } else {
                arr[k] = right[j];
                res += (n1 - i);
                k++;
                j++;
            }
        }
        while (i < n1) {
            arr[k] = left[i];
            k++;
            i++;
        }
        while (j < n2) {
            arr[k] = right[j];
            k++;
            j++;
        }
        return res;
    }

    public static int V16(int[] arr, int low, int high) {
        int res = 0;
        if (high > low) {
            int mid = low + (high - low) / 2;
            res += V16(arr, low, mid);
            res += V16(arr, mid + 1, high);
            res += V11(arr, low, mid, high);
        }
        return res;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int V18(int[] arr, int low, int high) {
        // if user wants to input, take index swap with last element and then proceed
        // with below implementation
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, high, i + 1);
        return i + 1;
    }

    public static int V19(int[] arr, int low, int h) {
        int pivot = arr[low];
        int i = low - 1;
        int j = h + 1;
        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);
            do {
                j--;
            } while (arr[j] > pivot);
            if (i >= j)
                return j;
            swap(arr, i, j);
        }
    }

    public static void V21(int[] arr, int l, int h) {
        if (h > l) {
            //lomuto
            // int p = V18(arr, l, h);
            // V21(arr, l, p-1);
            // V21(arr, p + 1, h);

            //hoare
            int p = V19(arr, l, h);
            V21(arr, l, p);
            V21(arr, p + 1, h);
        }
    }

    public static void main(String[] args) {

        // int arr1[] = {};
        // int arr2[] = { 20, 20, 20, 20, 30 };

        // intersection of two sorted arrays
        // V14
        // V14(arr1, arr2);

        // union
        // V15(arr1, arr2);

        // count inversions
        int arr[] = { 90, 140, 20, 50, 80, 90 };
        // int ans=V16(arr, 0, 4);

        // sort around a pivot
        // lomuto partition
        // int ans = V18(arr,0,arr.length-1);

        // hoare partition
        // int ans = V19(arr,0,arr.length-1);

        // quick sort
        V21(arr, 0, arr.length - 1);

        for (int i : arr) {
            System.out.println(i);
        }

        // System.out.println(ans);
    }
}