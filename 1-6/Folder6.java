class Folder6 {
    public static int V1(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target)
                return mid;
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int V2(int[] arr, int target, int low, int high) {
        if (low > high)
            return -1;
        int mid = (low + high) / 2;

        if (arr[mid] > target) {
            return V2(arr, target, low, mid - 1);
        }
        if (arr[mid] < target)
            return V2(arr, target, mid + 1, high);

        else {
            if (mid == 0 || arr[mid] != arr[mid - 1]) {
                return mid;
            } else {
                return V2(arr, target, low, mid - 1);
            }
        }
    }

    public static int V4(int[] arr, int target, int low, int high) {
        if (low > high)
            return -1;
        int mid = (low + high) / 2;

        if (arr[mid] > target) {
            return V2(arr, target, low, mid - 1);
        }
        if (arr[mid] < target)
            return V2(arr, target, mid + 1, high);

        else {
            if (mid == arr.length - 1 || arr[mid + 1] != arr[mid]) {
                return mid;
            } else {
                return V2(arr, target, mid + 1, high);
            }
        }
    }

    public static int V6(int[] arr, int target) {
        int first = V2(arr, target, 0, arr.length - 1);
        if (first == -1)
            return 0;
        else {
            return V4(arr, target, 0, arr.length - 1) - first + 1;
        }
    }

    public static int V7(int arr[]) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == 0) {
                low = mid + 1;
            } else {
                if (mid == 0 || arr[mid - 1] != 0) {
                    return arr.length - mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return 0;

    }

    public static int V8(int x) {
        int ans = -1;
        int low = 0;
        int high = x;
        while (low <= high) {
            int mid = (low + high) / 2;
            int msq = mid * mid;
            if (msq == x)
                return mid;
            else if (msq > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
                ans = mid;
            }
        }
        return ans;

    }

    public static int V9(int[] arr, int x) {
        if (arr[0] == x)
            return 0;
        int i = 1;
        while (arr[i] < x) {
            i = i * 2;
        }
        if (arr[i] == x)
            return i;
        return V2(arr, x, (i / 2) + 1, i - 1);
    }

    public static int V10(int arr[], int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target)
                return mid;
            if (arr[mid] > arr[low]) {
                if (target >= arr[low] && target < arr[mid]) {
                    high = mid - 1;
                } else {

                    low = mid + 1;
                }
            } else {
                if (target > arr[mid] && target <= arr[low]) {
                    low = mid + 1;
                } else {

                    high = mid - 1;
                }

            }
        }
        return -1;
    }

    public static int V11(int arr[]) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if ((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == arr.length - 1 || arr[mid] >= arr[mid + 1])) {
                return mid;
            }
            if (mid == 0 && arr[mid - 1] > arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {

        // V1-binary search
        // int arr[]={10,20,30,40,50,60};
        // int ans=V1(arr,60);

        // V2- recursive binary search
        // int arr[] = { 10, 20, 30, 40, 50, 60 };
        // int ans = V2(arr, 80, 0, arr.length - 1);

        // V4 index o first or last ooccurrence;
        // int arr[] = { 10, 20, 20, 20, 30, 40, 50, 60 };
        // int num = V2(arr, 20, 0, arr.length - 1);
        // while (num > 0 && arr[num] == arr[num - 1])
        // num--;

        // V5 last occurrence
        // int num = V4(arr, 20, 0, arr.length - 1);

        // V6 no of occurrences
        // int ans=V6(arr,20);

        // V7 count 1's in sorted array
        // int arr[] = { 1 };
        // int ans = V7(arr);

        // V8 square root
        // int x = 16;
        // int ans = V8(x);

        // int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18,
        // 19, 20 };
        // int ans = V9(arr, 15);

        // V10--sorted rotated array
        // int arr[] = { 10, 20, 5, 6, 7, 8, 9 };
        // int target = 30;
        // int ans=V10(arr, target);

        // V11 peak element
        int arr[] = { 5, 20, 40, 30, 20, 50, 60 };
        int ans = V11(arr);

        System.out.println(ans);
    }
}