class Folder4 {
    public static void V3(int n) {
        if (n == 0)
            return;
        V3(n - 1);
        System.out.println(n);
        V3(n - 1);

    }

    public static int V4(int n) {
        if (n == 1)
            return 0;
        return 1 + V4(n / 2);
        // prints floor of log (n)

    }

    public static void V4_2(int n) {
        if (n == 0)
            return;
        V4_2(n / 2);
        System.out.println(n % 2);

        // prints binary equivalent of a number
    }

    public static void V5_6(int n) {
        // if(n==0)return;
        // System.out.println(n);
        // V5(n-1);
        // print n to 1;

        if (n == 0)
            return;
        V5_6(n - 1);
        System.out.println(n);
        // print 1 to n
    }

    public static void V7(int n) {
        // if the last thing in a function is a recursive call its tail recursive and
        // can be optimizeed
        // if (n == 0)
        // return;
        // System.out.println(n);
        // V7(n - 1);

        // not supported in java
        // start:
        // if (n == 0)
        // return;
        // System.out.println(n);
        // n=n-1;// V7(n - 1);
        // goto start;
    }

    public static int V9(int n) {
        if (n == 1)
            return 1;
        return n + V9(n - 1);

        // TC-theta 1
        // ASC-theta n
    }

    public static boolean V10(String s, int l, int r) {

        if (l >= r)
            return true;
        return s.charAt(r) == s.charAt(l) && V10(s, l + 1, r - 1);

    }

    public static int V11(int n) {
        if (n <= 0)
            return 0;
        return (n % 10) + V11(n / 10);

        // Tc Theta d
        // ASc Theta d
    }

    public static int V12(int n, int a, int b, int c) {
        if (n == 0) {
            return 0;
        }
        if (n < 0)
            return -1;
        int res = (Math.max(V12(n - a, a, b, c), Math.max(V12(n - b, a, b, c), V12(n - c, a, b, c))));
        if (res == -1) {
            return -1;
        } else {
            return res + 1;
        }

        // TC-3^n;
    }

    public static void V13(String curr, String s, int n, int l) {
        if (n == l) {
            System.out.println(curr);
            return;
        }
        V13(curr, s, n + 1, l);
        V13(curr + s.charAt(n), s, n + 1, l);
    }

    public static void V14(int n, char A, char B, char C) {
        if (n == 1) {
            System.out.println("Move 1 from " + A + " to " + C);
            return;
        }
        V14(n - 1, A, C, B);
        System.out.println("Move " + n + " from " + A + " to " + C);
        V14(n - 1, B, A, C);

    }

    public static int V15(int n, int k) {
        if (n == 1) {
            return 0;
        }
        return (V15(n - 1, k) + k) % n;

        // TC -theta n
    }

    public static int V16(int[] arr, int n, int sum) {
        if (n == 0) {
            return (sum == 0) ? 1 : 0;
        }
        return (V16(arr, n - 1, sum - arr[n - 1]) + V16(arr, n - 1, sum));
    }

    public static void permuteRec(StringBuilder s, int idx) {

        // Base case
        if (idx == s.length() - 1) {
            System.out.println(s);
            return;
        }

        for (int i = idx; i < s.length(); i++) {

            // Swapping
            swap(s, idx, i);

            // First idx+1 characters fixed
            permuteRec(s, idx + 1);

            // Backtrack
            swap(s, idx, i);
        }
    }

    public static void V17(String s) {
        permuteRec(new StringBuilder(s), 0);
    }

    public static void swap(StringBuilder s, int i, int j) {
        char temp = s.charAt(i);
        s.setCharAt(i, s.charAt(j));
        s.setCharAt(j, temp);
    }

    public static void main(String args[]) {

        // V3 --recursion basics till V3
        // int n=3;
        // V3(n);

        // V4
        // int ans = V4(16);
        // V4_2(13);

        // V5 &V6
        // V5_6(5);

        // V7 tail recursion
        // V7(5);

        // V9 sum of natural no.s til n
        // int ans = V9(4);

        // V10 check pallindrome or not
        // String s = "abccba";
        // boolean ans = V10(s, 0, s.length() - 1);

        // V11 sum of digits
        // int n=10;
        // int ans=V11(n);

        // V12 ropes
        // int n = 9;
        // int a = 2;
        // int b = 2;
        // int c = 2;

        // int ans = V12(n, a, b, c);

        // V13 subsequences
        // String t = "ABC";
        // String curr="";
        // int n = 0;
        // int l = t.length();
        // V13(curr,t, n, l);

        // V14 --tower of hanoi
        // int n = 3;
        // char A = 'A';
        // char B = 'B';
        // char C = 'C';
        // V14(n, A, B, C);

        // V15 --josephus
        // if its 0 indexed
        // int ans = V15(5, 3);

        // if its 1 indexed
        // int ans = V15(5, 3)+1;

        // V16 count of subsets==sum
        // int arr[] = { 1,2,3};
        // int sum = 0;
        // int ans=V16(arr, arr.length, sum);

        // V17 all permutations of a string (n!)
        String s = "ABC";
        V17(s);

        // System.out.println(ans);
    }
}
