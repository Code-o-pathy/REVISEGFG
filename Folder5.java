class Folder5 {
    public static int V7(int arr[]) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[res]) {
                res = i;
            }
        }
        return res;

    }

    public static int V8(int arr[]) {
        int larg = 0;
        int sec = -1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[larg]) {
                sec = larg;
                larg = i;
            } else if (arr[i] != arr[larg]) {
                if (sec == -1 || arr[i] > arr[sec]) {
                    sec = i;
                }
            }
        }
        return sec;
    }

    public static boolean V9(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }

        }
        return true;

    }

    public static void V10(int arr[]) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }

    public static int V11(int arr[]) {
        int res = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[res - 1]) {
                arr[res] = arr[i];
                res++;
            }
        }
        return res;
    }

    public static void V12(int arr[]) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[count];
                arr[count] = arr[i];
                arr[i] = temp;

                count++;
            }
        }
    }

    public static void V13(int[] arr) {
        int last = arr[0];
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[n - 1] = last;
    }

    public static void reverse(int[] arr, int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void V14(int[] arr, int d) {
        reverse(arr, 0, d - 1);
        reverse(arr, d, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
        // Theta n time complexity
    }

    public static void V15(int[] arr) {
        int n=arr.length;
        int num=n-1;
        System.out.println(arr[n-1]);
        for(int i=n-2;i>=0;i--){
            if(arr[i]>arr[num]){
                System.out.println(arr[i]);
                num=i;
            }
        }
    }
    public static int V16(int[] arr){
        int minValue=Math.min(arr[0], arr[1]);
        int diff=arr[1]-arr[0];
        int n=arr.length;
        for(int i=2;i<n;i++){
            diff=Math.max(diff, arr[i]-minValue);
            minValue=Math.min(minValue, arr[i]);
        }
        return diff;
    }
    public static void V17(int arr[]){
        int count=1;
        int i=1;
        int n=arr.length;
        while(i<n){
            while(i<n && arr[i]==arr[i-1]){
                i++;
                count++;

            }
            System.out.println(arr[i-1]+" - "+count);
            count=1;
            i++;
        }
        if(n==1 || arr[n-1]!=arr[n-2]){
            System.out.println(arr[n-1]+" - "+1);

        }

    }

    public static int V18(int arr[]) {
        int ans=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>arr[i-1]){
                ans+=arr[i]-arr[i-1];
            }
        }


        return ans;
    }
    public static int V20(int[] arr){
        int  n=arr.length;
        int[] left=new int[n];
        int[] right=new int[n];
        left[0]=arr[0];
        right[n-1]=arr[n-1];
        int ans=0;
        for(int i=1;i<n;i++){
            left[i]=Math.max(left[i-1], arr[i]);
        }
        for(int i=n-2;i>=0;i--){
            right[i]=Math.max(right[i+1], arr[i]);
        }
        for(int i=0;i<n;i++){
            int currWater=Math.min(left[i],right[i])-arr[i];
            ans+=currWater;
        }
        return ans;
    }
    public static void main(String[] args) {
        // V7()largest element in array
        // int arr[]={10,55,30,8};
        // int ans=V7(arr);

        // V8() second largest
        // int arr[]={10,8};
        // int ans=V8(arr);

        // V9 sorted or not
        // int arr[]={12,15};
        // boolean ans=V9(arr);

        // V10 reverse
        // int arr[]={10,1};
        // V10(arr);
        // for(int c:arr){
        // System.out.print(c+" ");
        // }

        // V11 remove duplicates
        // int arr[] = { 1, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 5 };
        // int ans = V11(arr);
        // for (int c : arr) {
        // System.out.print(c + " ");
        // }

        // V12 move zeros
        // int arr[]={0,0,0,2,3,0,4,0,6,5};
        // V12(arr);
        // for (int c : arr) {
        // System.out.print(c + " ");
        // }

        // V13 left rotate by 1 or d;
        // int arr[]={1,2,3,4,5};
        // V13(arr);

        // V14(arr,2);
        // for (int c : arr) {
        // System.out.print(c + " ");
        // }

        // leaders
        // int arr[] = { 30,20,10 };
        // V15(arr);

        //max difference
        // int arr[]={30,10,8,2};
        // int ans=V16(arr);

        //frequencies in sorted array
        // int arr[]={60,10,10,20,20,20,30,30,30,50};
        // V17(arr);

        //stock buy and sell V18 and V19;
        // int arr[]={1,5,3,8,12};
        // int ans=V18(arr);

        //V20 trapping rain water;
        int arr[]={7,6,5};
        int ans=V20(arr);


        System.out.println(ans);
    }
}