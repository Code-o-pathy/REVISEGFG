import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class MyCmp implements Comparator<Point> {
    public int compare(Point p1, Point p2) {
        return p1.x - p2.x; // return increasing sorted order
        // return p2.x-p1.x; //returns in decreasing order
        // return p1.x%2-p2.x%2; //even first and then odd
    }
}

class Folder7_3 {
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

    public static int V27(int[] arr, int k) {
        int l = 0;
        int h = arr.length - 1;
        while (l <= h) {
            int p = V18(arr, l, h);
            if (p == (k - 1)) {
                return p;
            } else if (p > k - 1) {
                h = p - 1;
            } else {
                l = p + 1;
            }
        }
        return -1;
    }

    public static int V28(int[] arr, int m) {
        Arrays.sort(arr);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i + m - 1 < arr.length; i++) {
            res = Math.min(res, arr[i + m - 1] - arr[i]);
        }
        return res;
    }

    public static void V29(int[] arr) {
        int i = -1;
        int j = arr.length;
        while (true) {
            do {
                i++;
            }
            // while (arr[i] < 0); //for sorting negs and pos
            while (arr[i] == 0);
            do {
                j--;
            }
            // while (arr[j] >= 0);//for sorting negs and pos
            while (arr[j] != 0);
            if (i >= j)
                return;
            swap(arr, i, j);
        }
    }

    public static void V30(int arr[]) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, mid, low);
                mid++;
                low++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                swap(arr, mid, high);
                high--;
            }

        }
    }

    public static int V31(int arr[]) {
        int res = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            res = Math.min(res, arr[i + 1] - arr[i]);
        }
        return res;
    }

    public static void V32(Point arr[]) {
        Arrays.sort(arr, new MyCmp());
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[res].y >= arr[i].x) {
                arr[res].x = Math.min(arr[res].x, arr[i].x);
                arr[res].y = Math.max(arr[res].y, arr[i].y);
            } else {
                res++;
                arr[res] = arr[i];
            }

        }
        for (int i = 0; i <= res; i++) {
            System.out.println(arr[i].x + " " + arr[i].y);
        }
    }

    public static int V33(int arr[], int dep[]) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int curr = 1;
        int res = 1;
        int i = 1;
        int j = 0;
        while (i < arr.length && j < dep.length) {
            if (arr[i] <= dep[j]) {
                curr++;
                i++;
            } else {
                curr--;
                j++;
            }
            res = Math.max(res, curr);
        }
        return res;

    }

    public static void V34(int[] arr) {
        int n = arr.length;
        for (int cs = 0; cs < n - 1; cs++) {
            int item = arr[cs];
            int pos = cs;
            for (int i = cs + 1; i < n; i++) {
                if (arr[i] < item) {
                    pos++;
                }
            }
            int temp = item;
            item = arr[pos];
            arr[pos] = temp;

            while (pos != cs) {
                pos = cs;
                for (int i = cs + 1; i < n; i++) {
                    if (arr[i] < item) {
                        pos++;
                    }
                }
                int temp2 = item;
                item = arr[pos];
                arr[pos] = temp2;
            }
        }
    }

    public static void V35(int[] arr) {
        int n = arr.length;
        for (int i = (n - 2) / 2; i >= 0; i--) {
            V35_maxHeapify(arr, n, i);
        }
    }

    public static void V35_maxHeapify(int[] arr, int n, int i) {
        int largest = i;
        int left = (2 * i) + 1;
        int right = (2 * i) + 2;
        if (left < n && arr[left] > arr[largest])
            largest = left;
        if (right < n && arr[right] > arr[largest])
            largest = right;
        if (largest != i) {
            swap(arr, i, largest);
            V35_maxHeapify(arr, n, largest);
        }

    }

    public static void V35_heapSort(int arr[]) {
        int n = arr.length;
        V35(arr);
        for (int i = n - 1; i >= 1; i--) {
            swap(arr, 0, i);
            V35_maxHeapify(arr, i, 0);
        }
    }

    public static void V36(int[] arr, int k) {
        int[] count = new int[k];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        for (int i = 1; i < k; i++) {
            count[i] = count[i - 1] + count[i];
        }
        int[] output = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }

    }

    public static void V37(int arr[]) {
        int n = arr.length;
        int mx = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            mx = Math.max(arr[i], mx);
        }
        for (int exp = 1; mx / exp > 0; exp = exp * 10) {
            V37_helper(arr, n, exp);
        }
    }

    public static void V37_helper(int arr[], int n, int exp) {
        int count[] = new int[10];
        int output[] = new int[n];
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] = count[i - 1] + count[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    public static void V38(int arr[], int k) {
        int mx = 0;
        for (int i = 0; i < arr.length; i++) {
            mx = Math.max(mx, arr[i]);
        }
        mx++;
        ArrayList<ArrayList<Integer>> bkt = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < k; i++) {
            bkt.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < arr.length; i++) {
            int bi = (k * arr[i]) / mx;
            bkt.get(bi).add(arr[i]);
        }
       
        int index=0;
        for(int i=0;i<k;i++){
            Collections.sort(bkt.get(i));
            for(int j=0;j<bkt.get(i).size();j++){
                arr[index++]=bkt.get(i).get(j);
            }
        }
    }

    public static void main(String[] args) {
        // int arr[] = { 10, 1, 5, 38, 14, 19, 26 };

        // kth smallest element V27;
        // int k = 7;
        // int ans=V27(arr, k);

        // chocolate distribution problem
        // int m=3;
        // int ans=V28(arr,m);

        // segregate negs,pos, 0s,1s
        // int arr[] = { 0, 1, 0, 1, 0, 1 };
        // V29(arr);

        // dutch national flag algo
        // int arr[] = { 0, 1, 2, 2, 0, 1, 2, 0 };
        // V30(arr);

        // minimum difference in an array
        // int ans = V31(arr);

        // overlapping intervals
        // Point arr[] = { new Point(1, 3), new Point(2, 4), new Point(5, 7), new
        // Point(6, 8) };
        // V32(arr);

        // meeting maximum guests at a moment
        // int arr[] = { 730, 600, 700 };
        // int dep[] = { 1000, 800, 730 };
        // int ans = V33(arr, dep);

        // cycle sort for distinct no.s
        // int arr[] = { 20, 40, 50, 10, 30 };
        // V34(arr);

        // heapify ;
        // int arr[] = { 10, 15, 50, 4, 20 };
        // V35(arr);
        // heap sort
        // V35_heapSort(arr);

        // counting sort
        // int arr[] = { 1, 4, 4, 1, 0, 1 };
        // int k = 5;
        // V36(arr, k);

        // radix sort
        // int arr[] = { 319, 212, 6, 8, 100, 50 };
        // V37(arr);

        // bucket sort
        int arr[] = { 81,81,81,81,81 };
        int k = 4;
        V38(arr, k);

        // System.out.println(ans);

        for (int i : arr) {
            System.out.print(i + " ");
        }

    }
}