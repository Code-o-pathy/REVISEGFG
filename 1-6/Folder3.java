class Folder3 {
    public static void V1To5() {
        int a = 3;
        int b = 6;
        System.out.println(a & b); // output= 2
        System.out.println(a | b); // output= 7
        System.out.println(a ^ b); // output= 5
        System.out.println(a << 1); // output= a*2^1;
        System.out.println(a << 2); // output= a*2^2;
        System.out.println(a << b); // output= a*2^b;
        System.out.println(a >> 1); // output= (floor) a/2^1;
        System.out.println(a >> 2); // output= (floor) a/2^2;
        System.out.println(a >> b); // output= (floor) a/2^b;
        System.out.println(~5); // 2's compliment form is (2^n)-x;
        // the no. -5 would be stored as 2^32-1-5=2^32-6 ; -6 is the actual no which is
        // 2's compliment of -5;
        // System.out.println(-20>>>4); //unsigned right shift, in this when bits are
        // shifter to right the leading bits which are added are 0 irrespective of sign
        // of the input. In signed right shift, negative no.s right shift are done be
        // adding 1 and positive are done by 0
    }

    public static boolean V6(int n, int k) {
        // return ((n & (1<<(k-1))) !=0);
        // via left shift (!=0 because the result of and operator would be >=1 that is
        // non zero if its set or 0 if its not)

        return ((n >> (k - 1)) == 1);
        // here it says only one because we are doing and with 1 i.e. last bit of 32
        // bits, so if the kth bit was 1 it would result in either 1 or 0, >=1 is not an
        // optin thats why we can equate with 1,
    }

    public static int V7(int n) {
        // int count=0;
        // while(n>0){
        // if((n&1)==1){
        // count++;
        // }
        // n=n>>1;
        // }
        // return count;

        int count = 0;
        while (n > 0) {
            count += (n & 1);
            n = n >> 1;
        }
        return count;

        // Theta of total bits in 1;
    }

    public static int V7_2(int n) {
        // brian kerningam's algo
        // n&n-1;
        int count = 0;
        while (n > 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
        // theta of no of set bits.
    }

    public static int V7_3(int n) {
        // table lookup method;
        int[] table = new int[256];
        table[0] = 0;
        for (int i = 1; i < 256; i++) {
            table[i] = (i & 1) + table[i / 2];
        }
        int res = 0;
        for (int i = 0; i < 4; i++) {
            res += table[n & 0xff];
            n = n >> 8;
        }
        return res;

        // theta 1 solution
    }

    public static boolean V8(int n) {
        // using brian karnigam's algo

        // way1
        // int count=V7_2(n);
        // return count==1;

        // way 2
        // if(n==0) return false;
        // return (n & (n - 1)) == 0;

        // way3
        return ((n != 0) && (n & (n - 1)) == 0);

        // TC-theta of x,where x is no. of set bits

    }

    public static int V9(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res = res ^ arr[i];
        }
        return res;
    }

    public static int V9_2(int[] arr) {
        int res = 0;
        for (int i = 1; i <= arr.length + 1; i++) {
            res = res ^ i;
        }
        for (int i = 0; i < arr.length; i++) {
            res = res ^ arr[i];
        }
        return res;

    }

    public static void V10(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res = res ^ arr[i];
        }
        int bit = res & (~(res - 1));
        int res1 = 0;
        int res2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & bit) != 0) {
                res1 = res1 ^ arr[i];
            } else {

                res2 = res2 ^ arr[i];
            }
        }
        System.out.println(res1 + " " + res2);
        //TC-
    }

    public static void V11(String s){
        int n=s.length();
        int powSize=(int)Math.pow(2, n);
        for(int counter=0;counter<powSize;counter++){
            for(int j=0;j<n;j++){
                if((counter &(1<<j))!=0){
                    System.out.print(s.charAt(j));
                }
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {

        // V1To5(); --operators

        // V6 --is set or not
        // int n = 8;
        // int k = 3;
        // boolean ans = V6(n, k);

        // V7 --count set bits
        // int n = -2;
        // int ans=V7(n);
        // int ans = V7_2(n);

        // V8 --power of two
        // int n = 8;
        // boolean ans = V8(n);

        // V9 --oddly occurring no.(XOR)
        // int[] arr = { 1, 5, 4, 3, 6 };
        // int ans = V9(arr);
        // int ans=V9_2(arr);

        // V10 --two oddly occurring no.s
        // int arr[] = { 3, 3, 4, 4, 5, 6, 7, 7 };
        // V10(arr);

        //V11 --all substrings;
        V11("abc");

        // System.out.println(ans);

    }
}