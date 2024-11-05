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
    public static void V12(int arr[]){
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                int temp=arr[count];
                arr[count]=arr[i];
                arr[i]=temp;

                count++;
            }
        }
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
        //     System.out.print(c + " ");
        // }
        
        //V12 move zeros
        int arr[]={0,0,0,2,3,0,4,0,6,5};
        V12(arr);
        for (int c : arr) {
            System.out.print(c + " ");
        }

        // System.out.println(ans);
    }
}
