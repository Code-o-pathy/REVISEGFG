import java.util.*;

// class Point implements Comparable<Point> {
//     int x, y;

//     Point(int x, int y) {
//         this.x = x;
//         this.y = y;
//     }

//     public int compareTo(Point p) {
//         return this.x - p.x;
//         // return p.x-this.x;
//     }
// }
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

class Folder7_1 {
    public static void V3() {
        Point arr[] = { new Point(7, 3), new Point(6, 3), new Point(3, 3) };
        // Arrays.sort(arr, new MyCmp());
        for (Point p : arr) {
            System.out.println(p.x + " " + p.y);
        }

    }

    public static void V4() {
        List<Point> list = new ArrayList<Point>();
        list.add(new Point(4, 3));
        list.add(new Point(3, 3));
        list.add(new Point(6, 3));
        Collections.sort(list, new MyCmp());
        for (Point i : list) {
            System.out.println(i.x + " " + i.y);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void V6(int arr[]) {
        // bubble sort-its stable. tc-O(n*n);
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            if (swapped == false) {
                break;
            }
        }
    }

    public static void V7(int[] arr) {
        // selection sort-its unstable. tc-O(n*n);
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }

            }
            swap(arr, min, i);
        }

        // for(int i=0;i<n-1;i++){
        // int max=0;
        // for(int j=1;j<n-i;j++){
        // if(arr[j]>arr[max]){
        // max=j;
        // }

        // }
        // swap(arr, max, n-i-1);
        // }
    }

    public static void V8(int[] arr) {
        // insertion sort stable O(n*n) used for small size arrays
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        // theta n --best case --array should have been sortd
        // theta nsquare --worst case --array should have been reverse sortd
        // O nsquare --average case
    }

    public static int[] V10(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int m = n1 + n2;
        int[] ans = new int[m];
        int a1 = 0;
        int a2 = 0;
        int i = 0;
        while (a1 < n1 && a2 < n2) {
            if (arr1[a1] < arr2[a2]) {
                ans[i] = arr1[a1];
                a1++;
            } else {
                ans[i] = arr2[a2];
                a2++;
            }
            i++;
        }
        if (a1 >= n1) {
            while (a2 < n2) {
                ans[i] = arr2[a2];
                a2++;
                i++;
            }

        } else {
            while (a2 < n2) {
                ans[i] = arr1[a1];
                a1++;
                i++;
            }

        }
        return ans;
    }

    public static void main(String args[]) {
        // v3 arrays.sort;
        // V3();

        // V4 collections.sort;
        // V4();

        // int arr[] = { 9, 3, 2, 3, 4 };

        // V6 bubble sort
        // V6(arr);

        // V7 Selection sort
        // V7(arr);

        // V8 Insertion sort
        // V8(arr);

        // V10 merge two sorted arrays
        int arr1[] = { 1, 3, 5, 7, 9 };
        int arr2[] = { 2, 4, 6, 8, 10 };
        int arr[] = V10(arr1, arr2);

        for (int i : arr) {
            System.out.println(i);
        }

    }
}